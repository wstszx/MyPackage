package yc.mypackage.utils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by wstszx on 2018/3/6.
 */

public class Utils {
	/**
	 * 拨打电话（直接拨打电话）
	 *
	 * @param phoneNum 电话号码
	 */
	public static void callPhone(Context context, String phoneNum) {
		Intent intent = new Intent(Intent.ACTION_CALL);
		Uri data = Uri.parse("tel:" + phoneNum);
		intent.setData(data);
		if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			return;
		}
		context.startActivity(intent);
	}

	/**
	 * 拨打电话（跳转到拨号界面，用户手动点击拨打）
	 *
	 * @param phoneNum 电话号码
	 */
	public static void prePareCallPhone(Context context, String phoneNum) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		Uri data = Uri.parse("tel:" + phoneNum);
		intent.setData(data);
		context.startActivity(intent);
	}
}
