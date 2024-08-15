# RPCFramwork

---
基于java开发的简易RPC框架
---

完成了基本的注册中心功能
# 测试说明
先到rpc框架中检查com.TJJ.rpc.registry.RegistryTest 这个文件是否可以运行  
通过后再运行整体流程，先启动provider再启动consumer，同时要启动etcd以及其可视化工具   
注意目前的代码中消费者消费完之后，etcd的数据就被清空了。无法连续测试
# 提交说明
每次代码的提交确保项目可以直接运行
