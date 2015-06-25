package com.livio.sdl.ext;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.livio.sdl.utils.SdlUtils;
import com.smartdevicelink.proxy.RPCRequest;
import com.smartdevicelink.proxy.rpc.AddSubMenu;
import com.smartdevicelink.proxy.rpc.Image;
import com.smartdevicelink.proxy.rpc.Show;
import com.smartdevicelink.proxy.rpc.SoftButton;
import com.smartdevicelink.proxy.rpc.enums.TextAlignment;

public class SdlRequestFactoryExt {
	public static AtomicInteger SEQ = new AtomicInteger(100);

	public static RPCRequest addSubmenu(String submenuName, int position,
			int menuId) {
		if (submenuName == null) {
			throw new NullPointerException();
		}
		if (submenuName.length() <= 0) {
			throw new IllegalArgumentException();
		}

		AddSubMenu result = new AddSubMenu();
		result.setMenuID(menuId);
//		result.setCorrelationID(menuId);
		result.setMenuName(submenuName);
		result.setPosition(position);
		return result;
	}

	public static RPCRequest addSubmenu(String submenuName, int position) {
		if (submenuName == null) {
			throw new NullPointerException();
		}
		if (submenuName.length() <= 0) {
			throw new IllegalArgumentException();
		}

		AddSubMenu result = new AddSubMenu();
		result.setMenuID(SEQ.addAndGet(1));
		result.setMenuName(submenuName);
		result.setPosition(position);
		return result;
	}

	public static RPCRequest show(String line1, String line2, String line3,
			String line4, String statusBar, TextAlignment alignment,
			String imageName, List<SoftButton> softbuttons) {
		Show result = new Show();
		if (line1 != null) {
			result.setMainField1(line1);
		}
		if (line2 != null) {
			result.setMainField2(line2);
		}
		if (line3 != null) {
			result.setMainField3(line3);
		}
		if (line4 != null) {
			result.setMainField4(line4);
		}
		 
		if (statusBar != null) {
			result.setStatusBar(statusBar);
		}
		if (alignment != null) {
			result.setAlignment(alignment);
		}
		if (imageName != null) {
			Image image = SdlUtils.dynamicImage(imageName);
			result.setGraphic(image);
		}

		if (null != softbuttons && softbuttons.size() > 0) {
			result.setSoftButtons(softbuttons);
		}

		return result;
	}
}
