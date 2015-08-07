package com.smartdevicelink.transport;

/**
 * 监听Transport 状态，接收变更消息
 * @author html5app
 *
 */
public interface ITransportListener {
	// Called to indicate and deliver bytes received from transport
	void onTransportBytesReceived(byte[] receivedBytes, int receivedBytesLength);

	// Called to indicate that transport connection was established
	void onTransportConnected();

	// Called to indicate that transport was disconnected (by either side)
	void onTransportDisconnected(String info);

	// Called to indicate that some error occurred on the transport
	void onTransportError(String info, Exception e);
} // end-interface