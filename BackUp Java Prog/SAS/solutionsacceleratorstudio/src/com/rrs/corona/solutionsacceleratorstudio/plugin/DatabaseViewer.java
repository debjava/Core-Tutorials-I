
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import com.rrs.corona.solutionsacceleratorstudio.datasource.DatabaseManager;
import com.rrs.corona.solutionsacceleratorstudio.datasource.DbmsInfo;
import com.rrs.corona.solutionsacceleratorstudio.datasource.FieldInfo;
import com.rrs.corona.solutionsacceleratorstudio.datasource.TableInfo;
import com.rrs.corona.solutionsacceleratorstudio.dragdrop.DatabaseBean;
import com.rrs.corona.solutionsacceleratorstudio.dragdrop.DatabaseTransfer;

public class DatabaseViewer  extends ViewPart 
{
	public static TreeViewer viewer;
	private Action renameAction;
	private Action hideAction;
	private Action connectAction;
	private Action refreshAction;
	private Action manageDataSourceAction;
	private Action findAction;
	private Action doubleClickAction;
	public static IWorkbenchWindow fsite = null; // new Modification and can be removed
	
	class ViewContentProvider implements IStructuredContentProvider,ITreeContentProvider 
	{
		private TreeParent invisibleRoot;
		
		public void inputChanged(Viewer v, Object oldInput, Object newInput) 
		{
		}
		public void dispose() 
		{
		}
		public Object[] getElements(Object parent)
		{
			if (parent.equals(getViewSite())) 
			{
				if (invisibleRoot==null) 
					initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) 
		{
			if (child instanceof TreeObject) 
			{
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) 
		{
			if (parent instanceof TreeParent) 
			{
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) 
		{
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
		
		private void initialize()
		{			
			invisibleRoot = new TreeParent("");					
			TreeParent newDataSrc = new TreeParent("Data Sources");
			invisibleRoot.addChild(newDataSrc);	
		}
	}
	class ViewLabelProvider extends LabelProvider 
	{
		public String getText(Object obj) 
		{
			return obj.toString();
		}
		public Image getImage(Object obj) 
		{
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	class NameSorter extends ViewerSorter 
	{
	}
	
	/**
	 * The constructor.
	 */
	public DatabaseViewer() 
	{
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	
	public void createPartControl(Composite parent) 
	{
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		fsite = getViewSite().getWorkbenchWindow(); // New modification, can be removed
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		makeActions();
		hookContextMenu();
		
		viewer.addDragSupport(SWT.Move,new Transfer[] { DatabaseTransfer.getInstance() }, new DragSourceListener()
				{
			
			public void dragStart(DragSourceEvent event) 
			{
				// TODO Auto-generated method stub
				event.doit = true;
			}
			
			public void dragSetData(DragSourceEvent event)
			{
				DatabaseBean dataBean = new DatabaseBean();
				ArrayList fieldList = new ArrayList();
				HashMap fieldType = new HashMap();
				IStructuredSelection select = (IStructuredSelection) viewer.getSelection();
				TreeObject objTree = (TreeObject)select.getFirstElement();
				if(objTree.getType().equals("table"))
				{
					TreeParent objTreeParent = (TreeParent)select.getFirstElement();
					dataBean.setTableName(objTreeParent.getName());
					TreeObject []child = objTreeParent.getChildren();
					for(int i=0;i<child.length;i++)
					{
						fieldList.add(child[i].getName());
						fieldType.put(child[i].getName(),child[i].getDataType());
					}
					dataBean.setFieldMap(fieldList);
					dataBean.setFieldType(fieldType);
					dataBean.setTypeofData("table");
					event.data =dataBean;
				}
				else if(objTree.getType().equals("field"))
				{
					dataBean.setFieldName((String)objTree.getName());
					fieldList.add(objTree.getName());
					fieldType.put(objTree.getName(),objTree.getDataType());
					dataBean.setFieldMap(fieldList);
					dataBean.setFieldType(fieldType);
					dataBean.setTypeofData("field");
					event.data =dataBean;
				}
			}
			
			public void dragFinished(DragSourceEvent event)
			{
				// TODO Auto-generated method stub						
			}
			
				});
	}
	
	private void hookContextMenu() 
	{
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) 
			{
				DatabaseViewer.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}
	
	private void contributeToActionBars() 
	{
		IActionBars bars = getViewSite().getActionBars();
	}
	
	private void fillContextMenu(IMenuManager manager) {
		manager.add(renameAction);
		manager.add(hideAction);
		manager.add(connectAction);
		manager.add(refreshAction);
		manager.add(manageDataSourceAction);
		manager.add(findAction);
		manager.add(new Separator());		
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void makeActions() 
	{
		
		renameAction = new Action() // for rename action
		{
			public void run() 
			{
				RenameDataSourceDialog renameDsDialog = new RenameDataSourceDialog(viewer.getControl().getShell());
				renameDsDialog.open();
			}
		};
		renameAction.setText("Rename");
		renameAction.setToolTipText("Click here to rename");
		
		hideAction = new Action() // For hide action
		{
			public void run() 
			{
				IStructuredSelection select = (IStructuredSelection) viewer.getSelection();
				TreeObject table = (TreeObject) select.getFirstElement();
				TreeParent tableParent = table.getParent();
				tableParent.removeChild(table);
				viewer.refresh();
			}
		};
		hideAction.setText("Hide");
		hideAction.setToolTipText("click here to hide the Data Source");
		
		connectAction = new Action() 		// for connect action
		{
			public void run() 
			{
				
				showMessage("Data Source connected");
			}
		};
		connectAction.setText("Connect");
		connectAction.setToolTipText("Click here to connect");
		
		refreshAction = new Action()//		for refresh action 
		{
			public void run() 
			{
				IStructuredSelection select = (IStructuredSelection) viewer.getSelection();
				TreeObject table = (TreeObject) select.getFirstElement();
				TreeParent tableParent = table.getParent();
				tableParent.getChildren();
				viewer.refresh();
				showMessage("Data Source refreshed");
			}
		};
		refreshAction.setText("Refresh");
		refreshAction.setToolTipText("Click here to refresh");
		
		
		
		manageDataSourceAction = new Action() //		for manage tables action
		{
			public void run() 
			{
				ManageDataSourceDialog manageDsDialog = new ManageDataSourceDialog(viewer.getControl().getShell()); 
				manageDsDialog.open();
			}
		};
		manageDataSourceAction.setText("Manage Data Source");
		manageDataSourceAction.setToolTipText("Click here to manage tables");		
		
		findAction = new Action() // for Find Action
		{
			public void run() 
			{
				FindDataDialog findDataDialog = new FindDataDialog(viewer.getControl().getShell());
				
				findDataDialog.open();
			}
		};
		//findAction.setAccelerator(SWT.CTRL+'F');
		findAction.setText("Find");
		findAction.setToolTipText("Click here to find");		
	}
	
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) 
			{
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) 
	{
		MessageDialog.openInformation(viewer.getControl().getShell(), "Solutions Accelerator Studio", message );	
	}
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() 
	{
		viewer.getControl().setFocus();
	}
}

class TreeObject implements IAdaptable 
{
	private String name;
	private TreeParent parent;
	private String type;
	private String dataType;
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public TreeObject(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setParent(TreeParent parent) {
		this.parent = parent;
	}
	public TreeParent getParent() {
		return parent;
	}
	public String toString() {
		return getName();
	}
	public Object getAdapter(Class key) {
		return null;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

class TreeParent extends TreeObject 
{
	private ArrayList children;
	public TreeParent(String name) 
	{
		super(name);
		children = new ArrayList();
	}
	public void addChild(TreeObject child) 
	{
		children.add(child);
		child.setParent(this);
	}
	public void removeChild(TreeObject child) 
	{
		children.remove(child);
		child.setParent(null);
	}
	public TreeObject [] getChildren() 
	{
		return (TreeObject [])children.toArray(new TreeObject[children.size()]);
	}
	public boolean hasChildren() 
	{
		return children.size()>0;
	}
}

