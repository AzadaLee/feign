# ribbon重试机制相关参数说明

#1、 spring.cloud.loadbalancer.retry.enabled=true
## 该参数用来开启重试机制，从Camden SR2版本开始就已经默认是开启状态；
## 注意：该参数尝试几次是不起作用的，如果想关闭尝试机制可以通过ribbon.MaxAutoRetriesNextServer和ribbon.MaxAutoRetries 设置为0进行关闭尝试机制

#2、hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds
## 断路器的超时时间，如果开启了尝试机制，需要将该参数设置大于Ribbon的超时时间，否则不会触发尝试

#3、 ribbon.ConnectionTimeout

#4、 ribbon.ReadTimeout

#5、 ribbon.MaxAutoRetries 对当前节点的重试次数
## 如果当前请求发生ConnectionTimeout或ReadTimeout，或再次对该节点发送设定的次数

#6、ribbon.MaxAutoRetriesNextServer 切换节点的重试次数
## 当前调用节点如果发生ConnectionTimeout或ReadTimeout，会切换节点进行尝试，并对新节点进行ribbon.MaxAutoRetries设定次数的调用；切换节点的次数可以设定

## 如果把ribbon.MaxAutoRetries和ribbon.MaxAutoRetriesNextServer设置为0，则代表never retry