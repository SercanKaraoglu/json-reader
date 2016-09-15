package app.connection

object ConnectionBuilder {
  private val DEFAULT_BUFFER_SIZE: Int = 1024
  private val DEFAULT_RECONNECT_TIME_IN_SECOND: Int = 1024
  private val DEFAULT_HEARBEAT_INTERVAL_IN_SECOND: Int = 1
  private val DEFAULT_ENABLE_RECONNECT: Boolean = true
  private val DEFAULT_SHOULD_SEND_HEARTBEAT: Boolean = true
}

class ConnectionBuilder {
  private var bufferSize: Int = ConnectionBuilder.DEFAULT_BUFFER_SIZE
  private var name: String = null
  private var address: String = null
  private var group: String = null
  private var port: Int = 0
  private var userName: String = null
  private var password: String = null
  private var enableReconnect: Boolean = ConnectionBuilder.DEFAULT_ENABLE_RECONNECT
  private var reconnectTimeInSecond: Int = ConnectionBuilder.DEFAULT_RECONNECT_TIME_IN_SECOND
  private var heartbeatInterval: Int = ConnectionBuilder.DEFAULT_HEARBEAT_INTERVAL_IN_SECOND
  private var shouldSendHeartbeat: Boolean = ConnectionBuilder.DEFAULT_SHOULD_SEND_HEARTBEAT

  def setAddress(address: String): ConnectionBuilder = {
    this.address = address
    this
  }

  def setPort(port: Int): ConnectionBuilder = {
    this.port = port
    this
  }

  def setUserName(userName: String): ConnectionBuilder = {
    this.userName = userName
    this
  }

  def setName(name: String): ConnectionBuilder = {
    this.name = name
    this
  }

  def setPassword(password: String): ConnectionBuilder = {
    this.password = password
    this
  }

  def setBufferSize(bufferSize: Int): ConnectionBuilder = {
    this.bufferSize = bufferSize
    this
  }

  def setGroup(group: String): ConnectionBuilder = {
    this.group = group
    this
  }

  def setReconnectTime(second: Int): ConnectionBuilder = {
    this.reconnectTimeInSecond = second
    this
  }


  def setHeartbeatInterval(second: Int): ConnectionBuilder = {
    this.heartbeatInterval = second
    this
  }

  def setEnableReconnect(enableReconnect: Boolean): ConnectionBuilder = {
    this.enableReconnect = enableReconnect
    this
  }

  def setShouldSendHeartbeat(shouldSendHeartbeat: Boolean): ConnectionBuilder = {
    this.shouldSendHeartbeat = shouldSendHeartbeat
    this
  }

  def getEnableReconnect: Boolean = {
    this.enableReconnect
  }

  def getShouldSendHeartbeat: Boolean = {
    this.shouldSendHeartbeat
  }

  def getReconnectTime: Int = {
    this.reconnectTimeInSecond
  }

  def getAddress: String = {
    this.address
  }

  def getPort: Int = {
    this.port
  }

  def getUserName: String = {
    this.userName
  }

  def getPassword: String = {
    this.password
  }

  def getBufferSize: Int = {
    this.bufferSize
  }

  def getName: String = {
    this.name
  }

  def getGroup: String = {
    this.group
  }

  def getHeartbeatInterval: Int = {
    this.heartbeatInterval
  }

  override def toString: String = {
    "Connection [name=" + this.name + ", address=" + this.address + ", group=" + this.group + ", port=" + this.port + ", userName=" + this.userName + ", password=" + this.password + ", bufferSize=" + this.bufferSize + "]"
  }
}