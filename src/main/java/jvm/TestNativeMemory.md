#启动参数
-Xms20m -Xmx20m -Xmn10m -XX:NativeMemoryTracking=summary -XX:MaxDirectMemorySize=20m -XX:+PrintGCDetails  

禁用显示调用System.gc() 直接内存会oom  
-XX:+DisableExplicitGC  

#jcmd 排查堆外内存配合 -XX:NativeMemoryTracking=summary
jcmd <pid> VM.native_memory [summary | detail | baseline | summary.diff | detail.diff | shutdown] [scale= KB | MB | GB]

-XX:NativeMemoryTracking=[off | summary | detail]  

summary: 分类内存使用情况.  
detail: 详细内存使用情况，除了summary信息之外还包含了虚拟内存使用情况。  
baseline: 创建内存使用快照，方便和后面做对比  
summary.diff: 和上一次baseline的summary对比  
detail.diff: 和上一次baseline的detail对比  
shutdown: 关闭NMT  

## 用法
jcmd pid VM.native_memory