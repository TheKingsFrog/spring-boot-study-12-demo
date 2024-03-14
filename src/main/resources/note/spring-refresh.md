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
