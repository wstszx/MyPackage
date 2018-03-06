package yc.mypackage.widget;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import yc.mypackage.R;


/**
 * Created by wstszx on 2018/3/6.
 */

public class DialogFragmentHelper {
	private static final String TAG_HEAD = DialogFragmentHelper.class.getSimpleName();
	private static final String PROMPT_TAG = TAG_HEAD + ":prompt";

	public static void showPrompt(FragmentManager fragmentManager, boolean cancelable, final int layoutId, CommonDialogFragment.OnDialogCancelListener cancelListener) {
		CommonDialogFragment commonDialogFragment = CommonDialogFragment.newInstance(new CommonDialogFragment.OnGetDialogListener() {
			@Override
			public Dialog getDialog(Context context) {
				AlertDialog alertDialog = new AlertDialog.Builder(context).setView(layoutId).create();
				return alertDialog;
			}
		}, cancelable);
		commonDialogFragment.show(fragmentManager, PROMPT_TAG);
	}
}
