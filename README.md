# ViewValidateAnnotation
自己写的一个表单验证框架(未在生产环境使用测试，因此仅供学习参考使用)。

<h3><strong>目前包含的验证类型有:</strong></h3>

1.TextRequired  验证文本框内容是否为空

2.TextLength  验证文本框内容长度是否符合要求

3.ContentMatch  对文本框内容进行验证，例如文本框内容是否满足指定的正则表达式、文本框内容是否和指定的其他文本框内容一致等

<h3><strong>注意事项:</strong></h3>本项目中的框架以及demo在API 28的手机上正常运行，对于API 23(Android 6.0)及以下的手机，请先将Factory类代码中的Field实例.getDeclaredAnnotation调用改为Field实例.getAnnotation调用，即可正常运行。



以上。本项目为本人首次在github上建立的项目，如代码中有不足之处或有改进建议，欢迎各位指正！

<h3><strong>演示效果</strong></h3>

![image](https://github.com/ThinkExplorer/ViewValidateAnnotation/blob/master/ViewValidateAnnotation/demo.gif)



<h3><strong>License</strong></h3>

Copyright 2020 ThinkExplorer

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
