

SdlService: 
1. startSdlProxy
2. createSdlProxyObject
3. SdlProxyALM

SdlProxyALM:
4. 构造函数

SdlProxyBase:
5. performBaseCommon (563 ->　340 )
6. initializeProxy (504)
7. this.sdlSession.startSession()  (1023)

SdlSession:
8. startSession  (98)
9. connection = new SdlConnection(this.transportConfig);      (104)

SdlConnection:
9.1 构造函数   (43)


9.2
- wifi   TCPTransport    (63)
- BT	 BTTransport     (59)
- USB	 USBTransport    (65)


SdlSession:
10.  8中步骤
connection.registerSession(this);　　(112)  

SdlConnection:
11. registerSession

TCPTransport: 
12. openConnection

TCPTransport.TCPTransportThread: 
13. connect                         (313) 

java.net.Socket.Socket:
14. socket

