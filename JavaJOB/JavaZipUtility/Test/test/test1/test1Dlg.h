// test1Dlg.h : header file
//

#if !defined(AFX_TEST1DLG_H__5C5A3449_D71B_4387_97FF_4BC947837267__INCLUDED_)
#define AFX_TEST1DLG_H__5C5A3449_D71B_4387_97FF_4BC947837267__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CTest1Dlg dialog

class CTest1Dlg : public CDialog
{
// Construction
public:
	CTest1Dlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(CTest1Dlg)
	enum { IDD = IDD_TEST1_DIALOG };
	int		m_operand1;
	int		m_operand2;
	int		m_result;
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CTest1Dlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CTest1Dlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	virtual void OnOK();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_TEST1DLG_H__5C5A3449_D71B_4387_97FF_4BC947837267__INCLUDED_)
