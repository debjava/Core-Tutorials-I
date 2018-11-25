package com.rrs.corona.solutionsacceleratorstudio.dragdrop;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;


public class DatabaseTransfer extends ByteArrayTransfer
{
    private static final int Databae_ID = registerType ("");
    private static final DatabaseTransfer INSTANCE = new DatabaseTransfer();

    public static DatabaseTransfer getInstance ()
    {
        return INSTANCE;
    }

    protected int[] getTypeIds ()
    {
        return new int[] { Databae_ID };
    }

    protected String[] getTypeNames ()
    {
        return new String[] { "" };
    }

    protected void javaToNative (Object object, TransferData transferData)
    {
        if ((object == null) || !(object instanceof DatabaseBean))
        {
            return;
        }

        final DatabaseBean dataBean = (DatabaseBean) object;

        if (isSupportedType (transferData))
        {
            try
            {
                final ByteArrayOutputStream stream = new ByteArrayOutputStream();
                final DataOutputStream out = new DataOutputStream(stream);
                out.writeUTF (dataBean.getTypeofData ());

                if (dataBean.getTypeofData ().equals ("table") &&
                        (dataBean.getTableName () != null))
                {
                    out.writeUTF (dataBean.getTableName ());

                    ArrayList fieldList = dataBean.getFieldMap ();
                    HashMap fieldType = dataBean.getFieldType ();
                    out.writeUTF (String.valueOf (fieldList.size ()));

                    for (int i = 0; i < fieldList.size (); i++)
                    {
                        out.writeUTF ((String) fieldList.get (i));
                        out.writeUTF ((String) fieldType.get (fieldList.get (i)));
                    }
                }
                else if (dataBean.getTypeofData ().equals ("field") &&
                             (dataBean.getFieldName () != null))
                {
                    out.writeUTF (dataBean.getFieldName ());

                    ArrayList fieldList = dataBean.getFieldMap ();
                    HashMap fieldType = dataBean.getFieldType ();
                    out.writeUTF (String.valueOf (fieldList.size ()));

                    for (int i = 0; i < fieldList.size (); i++)
                    {
                        out.writeUTF ((String) fieldList.get (i));
                        out.writeUTF ((String) fieldType.get (fieldList.get (i)));
                    }
                }

                out.close ();
                super.javaToNative (stream.toByteArray (), transferData);
            }
            catch (Exception e)
            {
                e.printStackTrace ();
            }
        }
    }

    protected Object nativeToJava (TransferData transferData)
    {
        DatabaseBean dataBean = null;
        ArrayList fieldList = new ArrayList();
        HashMap fieldType = new HashMap();

        if (isSupportedType (transferData))
        {
            final byte[] raw = (byte[]) super.nativeToJava (transferData);

            if (raw == null)
            {
                return null;
            }

            dataBean = new DatabaseBean();

            try
            {
                final ByteArrayInputStream stream = new ByteArrayInputStream(raw);
                final DataInputStream inPut = new DataInputStream(stream);

                String typeOfdata = inPut.readUTF ();
                dataBean.setTypeofData (typeOfdata);

                if (typeOfdata.equals ("table"))
                {
                    dataBean.setTableName (inPut.readUTF ());

                    int size = Integer.parseInt (inPut.readUTF ());

                    for (int i = 0; i < size; i++)
                    {
                        String field = inPut.readUTF ();
                        fieldList.add (field);
                        fieldType.put (field, inPut.readUTF ());
                    }
                }
                else if (typeOfdata.equals ("field"))
                {
                    dataBean.setFieldName (inPut.readUTF ());

                    int size = Integer.parseInt (inPut.readUTF ());

                    for (int i = 0; i < size; i++)
                    {
                        String field = inPut.readUTF ();
                        fieldList.add (field);
                        fieldType.put (field, inPut.readUTF ());
                    }
                }

                dataBean.setFieldMap (fieldList);
                dataBean.setFieldType (fieldType);
                inPut.close ();
            }
            catch (IOException e)
            {
                e.printStackTrace ();

                return null;
            }
        }

        return dataBean;
    }
}
