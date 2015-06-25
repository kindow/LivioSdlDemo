package com.livio.sdl.ext;

import android.widget.Toast;

import com.livio.sdl.SdlService;
import com.livio.sdl.menu.CommandButton;
import com.livio.sdl.menu.MenuItem;
import com.livio.sdl.menu.CommandButton.OnClickListener;
import com.smartdevicelink.proxy.RPCRequest;
import com.smartdevicelink.proxy.rpc.AddCommand;
import com.smartdevicelink.proxy.rpc.AddCommandResponse;

public class SdlServiceExt extends SdlService {
	@Override
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
						commonButtonClickAction(button);
					}
				});

		return result;
	}

	protected void commonButtonClickAction(CommandButton button) {
		// TODO Auto-generated method stub
		MenuItem menu1 = menuManager.getSubmenus().get(0);
		MenuItem menu2 = menuManager.getSubmenus().get(1);
		if (button.getParentId() == menu1.getId()) {
			showToast(button.getName() + "¡¡is a child of " + menu1.getName());
		} else if (button.getParentId() == menu2.getId()) {
			showToast(button.getName() + "¡¡is a child of " + menu2.getName());
		} else {
			showToast(button.getName() + "¡¡is clicked ");
		}
	}

	private void showToast(String msg) {
		if (toast == null) {
			toast = Toast.makeText(SdlServiceExt.this, "", Toast.LENGTH_LONG);
		}

		toast.setText(msg);
		toast.show();
	}

}
