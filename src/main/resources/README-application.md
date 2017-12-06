# ribbon重试机制相关参数说明

# 1、 spring.cloud.loadbalancer.retry.enabled=true
## 该参数用来开启重试机制，从Camden SR2版本开始就已经默认是开启状态；
## 注意：该参数尝试几次是不起作用的，如果想关闭尝试机制可以通过ribbon.MaxAutoRetriesNextServer和ribbon.MaxAutoRetries 设置为0进行关闭尝试机制

# 2、hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds
## 断路器的超时时间，如果开启了尝试机制，需要将该参数设置大于Ribbon的超时时间，否则不会触发尝试

# 3、 ribbon.ConnectionTimeout

# 4、 ribbon.ReadTimeout

# 5、 ribbon.MaxAutoRetries 对当前节点的重试次数
## 如果当前请求发生ConnectionTimeout或ReadTimeout，或再次对该节点发送设定的次数

# 6、ribbon.MaxAutoRetriesNextServer 切换节点的重试次数
## 当前调用节点如果发生ConnectionTimeout或ReadTimeout，会切换节点进行尝试，并对新节点进行ribbon.MaxAutoRetries设定次数的调用；切换节点的次数可以设定

## 如果把ribbon.MaxAutoRetries和ribbon.MaxAutoRetriesNextServer设置为0，则代表never retry

# 7、feign.hystrix.enabled = true
## 打开feign的熔断机制，可自定义异常

## 说明：如果在fallback中继续抛出异常，在调用处需要进行捕获，否则controllerAdvice出捕获的异常为hystrix抛出的异常；如果在fallback中进行正常的返回，则在调用处无需做特殊处理