package yc.mypackage.widget;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by wstszx on 2018/3/6.
 */

public class CommonDialogFragment extends DialogFragment {
	private OnGetDialogListener mGetDialogListener;
	private OnDialogCancelListener mDialogCancelListener;

	public interface OnGetDialogListener{
		Dialog getDialog(Context context);
	}

	public interface OnDialogCancelListener{
		void onCancel();
	}

	public static CommonDialogFragment newInstance(OnGetDialogListener onGetDialogListener,boolean cancelable) {
		return newInstance(onGetDialogListener,cancelable,null);
	}

	public static CommonDialogFragment newInstance(OnGetDialogListener dialogListener,boolean cancelable,OnDialogCancelListener cancelListener) {
		CommonDialogFragment fragment = new CommonDialogFragment();
		fragment.setCancelable(cancelable);
		fragment.mDialogCancelListener = cancelListener;
		fragment.mGetDialogListener = dialogListener;
		return fragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		if (null == mGetDialogListener) {
			super.onCreateDialog(savedInstanceState);
		}
		return mGetDialogListener.getDialog(getActivity());
	}

	@Override
	public void onStart() {
		super.onStart();
		Dialog dialog = getDialog();
		if (dialog != null) {
			//在5.0以下的版本会出现白色背景边框，若在5.0以上设置则会造成文字部分的背景也变成透明
			if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
				//目前只有这两个dialog会出现边框
				if (dialog instanceof DatePickerDialog) {
					getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				}
			}
			Window window = getDialog().getWindow();
			WindowManager.LayoutParams attributes = window.getAttributes();
			attributes.dimAmount = 0.0f;
			window.setAttributes(attributes);
		}
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
		if (mDialogCancelListener != null) {
			mDialogCancelListener.onCancel();
		}
	}
}
