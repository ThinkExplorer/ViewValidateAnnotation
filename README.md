# ViewValidateAnnotation
自己写的一个表单验证框架(注解技术实现。未在生产环境使用测试，因此仅供学习参考使用)。

<h3><strong>目前包含的验证类型有:</strong></h3>

1.TextRequired  验证文本框内容是否为空

2.TextLength  验证文本框内容长度是否符合要求

3.ContentMatch  对文本框内容进行验证，例如文本框内容是否满足指定的正则表达式、文本框内容是否和指定的其他文本框内容一致等

<h3><strong>注意事项:</strong></h3>本项目中的框架以及demo在API 28的手机上正常运行，对于API 23(Android 6.0)及以下的手机，请先将Factory类代码中的Field实例.getDeclaredAnnotation调用改为Field实例.getAnnotation调用，即可正常运行。



以上。本项目为本人首次在github上建立的项目，如代码中有不足之处或有改进建议，欢迎各位指正！

<h3><strong>演示效果</strong></h3>

![image](https://github.com/ThinkExplorer/ViewValidateAnnotation/blob/master/ViewValidateAnnotation/demo.gif)


<h3><strong>MIT License</strong></h3>

Copyright (c) 2020 ThinkExplorer

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
