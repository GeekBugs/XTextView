# XTextView
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/F1ReKing/XTextView/LICENSE)
[![](https://jitpack.io/v/F1ReKing/XTextView.svg)](https://jitpack.io/#F1ReKing/XTextView) 

一个 多种多样的TextView 集合库

## 引入
#### Step 1. Add the JitPack repository to your build file
```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

#### Step 2. Add the dependency
```
	dependencies {
	       compile 'com.github.F1ReKing:XTextView:v0.1'
	}
```

## 介绍
### GradientTextView
![](https://ws2.sinaimg.cn/large/006tKfTcgy1fjw87pjposj30k004hglv.jpg)
#### 使用：
```
<com.f1reking.library.GradientTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp"
    android:text="这是一段渐渐消失的文字"
    android:textColor="#ffffff"
    android:textSize="14sp"
    app:gradientLength="5"
    />
```

#### 属性：
| 属性名 | 字段 | 描述 | 默认值 |
|---|---|---|---|
| gradientLength | integer | 渐变长度| 3 |
| startColor | color | 渐变开始颜色  | #ffffffff |
| endColor | color | 渐变结束颜色  | #00000000 |

## License

    Copyright 2017 F1ReKing. 

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
