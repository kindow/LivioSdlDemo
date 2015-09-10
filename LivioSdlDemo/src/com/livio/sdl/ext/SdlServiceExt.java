package com.livio.sdl.ext;

import java.util.List;
import java.util.logging.Logger;

import android.widget.Toast;

import com.livio.sdl.SdlService;
import com.livio.sdl.menu.CommandButton;
import com.livio.sdl.menu.CommandButton.OnClickListener;
import com.livio.sdl.menu.MenuItem;
import com.smartdevicelink.exception.SdlException;
import com.smartdevicelink.proxy.IProxyListener;
import com.smartdevicelink.proxy.RPCRequest;
import com.smartdevicelink.proxy.rpc.AddCommand;
import com.smartdevicelink.proxy.rpc.AddCommandResponse;
import com.smartdevicelink.proxy.rpc.DisplayCapabilities;
import com.smartdevicelink.proxy.rpc.OnAppInterfaceUnregistered;
import com.smartdevicelink.proxy.rpc.RegisterAppInterfaceResponse;
import com.smartdevicelink.proxy.rpc.SetDisplayLayout;
import com.smartdevicelink.proxy.rpc.UnregisterAppInterfaceResponse;

/**
 * onXXX 方法用于 service 接受车机响应
 * 
 * @author html5app
 *
 */
public class SdlServiceExt extends SdlService implements IProxyListener {
	Logger logger = Logger.getLogger(SdlServiceExt.class.getName());
	@Override
	/**
	 * Command Add Response
	 */
	public void onAddCommandResponse(AddCommandResponse response) {
		sendMessageResponse(response);

		int correlationId = response.getCorrelationID();
		RPCRequest original = removeFromRequestQueue(correlationId);

		if (response.getSuccess() && original != null) {
			MenuItem button = createMenuItem((AddCommand) original);
			if (button != null) {
				menuManager.addItem(button);
			}
		}
	}

	/**
	 * Translates the AddCommand object into a MenuItem object, complete with a
	 * click listener.
	 * 
	 * @param command
	 *            The command to translate
	 * @return The translated MenuItem object
	 */
	@Override
	protected MenuItem createMenuItem(AddCommand command) {
		final String name = command.getMenuParams().getMenuName();
		final int id = command.getCmdID();
		int parentId;
		final Integer parentInteger = command.getMenuParams().getParentID();
		if (parentInteger == null) {
			parentId = -1;
		} else {
			parentId = parentInteger;
		}

		final MenuItem result = new CommandButton(name, id, parentId,
				new OnClickListener() {
					@Override
					public void onClick(CommandButton button) {
						customButtonClickAction(button);
					}
				});

		return result;
	}

	/**
	 * 车机点击后手机响应事件
	 * 
	 * @param button
	 */
	protected void customButtonClickAction(CommandButton button) {
		// TODO Auto-generated method stub
		MenuItem menu1 = menuManager.getSubmenus().get(0);
		MenuItem menu2 = menuManager.getSubmenus().get(1);
		if (button.getParentId() == menu1.getId()) {
			showToast(button.getName() + "　is a child of " + menu1.getName());
		} else if (button.getParentId() == menu2.getId()) {
			showToast(button.getName() + "　is a child of " + menu2.getName());
		} else {
			showToast(button.getName() + "　is clicked ");
		}
	}

	private void showToast(String msg) {
		if (toast == null) {
			toast = Toast.makeText(SdlServiceExt.this, "", Toast.LENGTH_LONG);
		}

		toast.setText(msg);
		toast.show();
	}

	@Override
	public void onProxyOpened() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRegisterAppInterfaceResponse(
			RegisterAppInterfaceResponse response) {
		// TODO Auto-generated method stub
		DisplayCapabilities dc;
		try {
			dc = super.sdlProxy.getDisplayCapabilities();
			List<String> tps = dc.getTemplatesAvailable();
			for (String string : tps) {
				logger.info("tps info: " + string);
			}
			SetDisplayLayout command = new SetDisplayLayout();
			command.setDisplayLayout(tps.get(0));
			sendRpcRequest(command);
		} catch (SdlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onOnAppInterfaceUnregistered(
			OnAppInterfaceUnregistered notification) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnregisterAppInterfaceResponse(
			UnregisterAppInterfaceResponse response) {
		// TODO Auto-generated method stub

	}

}
