# spring刷新方法

方法前的`throws`：告诉使用方法的用户，这里可能会抛出哪些异常

`StartupStep`：执行流程记录

## 1.prepareRefresh()

默认赋值：

`startupDate`：记录当前上下文启动的时间

`closed`：该flag表示上下文是否已经关闭

`active`：该flag表示上下文是否已经激活

### 1.1 initPropertySources()

初始化资源

`initPropertySources()`：该方法是预留的扩展方法

springboot默认会走进`org.springframework.web.context.support.GenericWebApplicationContext#initPropertySources`

①获取环境`getEnvironment()`

这时候拿到的Environment是ApplicationServletEnvironment，在`getOrCreateEnvironment`的时候就调用过getEnvironment了

getorCreateEnvironment：调用的是GenericWebApplicationContext的createEnvironment，返回`ApplicationServletEnvironment`

为什么会返回`ApplicationServletEnvironment`？

--因为springboot启动时run方法里一开始会实例化SpringApplication，里面有一个`WebApplicationType.deduceFromClasspath()`，里面会判断后返回`WebApplicationType.SERVLET`。

这个枚举会在`getOrCreateEnvironment`方法用于判断返回`ApplicationServletEnvironment`。该类是`StandardServletEnvironment`的子类

校验需要的资源

`getEnvironment().validateRequiredProperties()`：
