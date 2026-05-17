# 实验二：第二次实验项目上传及结果展示
> The second assignment of E2 (6/5)

---

### 任务 1：首个 Kotlin APP 的构建
*(项目文件夹：`E2-2-1MyFirstKotlinApp`)*

<img width="1280" height="764" alt="E2-2-1" src="https://github.com/user-attachments/assets/13058b36-f4d5-4175-a9e1-83ada2c4952b" />

---

### 任务 2：按照教程完成 Compose 布局的实践步骤
*(项目文件夹：`E2-2-2BasicCodelab`)*

**1. 为 Greeting 设置背景色**

<img width="1280" height="764" alt="E2-2-2-1" src="https://github.com/user-attachments/assets/36a90f2a-35bd-4960-ad00-dfe9a93ff764" />

**2. 为默认修饰符添加内边距：`modifier.padding(24.dp)`**

<img width="1280" height="764" alt="E2-2-2-2" src="https://github.com/user-attachments/assets/4324a846-5e75-42b6-bc5d-88886716eb71" />

**3. 使 Greeting 子集垂直放置**

<img width="1280" height="764" alt="E2-2-2-3" src="https://github.com/user-attachments/assets/80506a34-16d9-419b-bbe7-2b99e872c905" />

**4. 使用循环向 `Column` 中添加元素**

<img width="1280" height="764" alt="E2-2-2-4" src="https://github.com/user-attachments/assets/501a5452-5f72-4cd2-830b-cf1b3119ffa5" />

**5. 模拟小屏幕手机宽度，向 `@Preview` 注解添加 `widthDp` 参数**

<img width="1280" height="764" alt="E2-2-2-5" src="https://github.com/user-attachments/assets/2a64312b-5b4d-4678-a835-3c20cd3de03e" />

**6. 使用 `fillMaxWidth` 和 `padding` 优化排版**

<img width="1280" height="764" alt="E2-2-2-6" src="https://github.com/user-attachments/assets/a9a3373e-f02b-4d0e-aa6e-3f722d170638" />

**7. 添加可点击按钮**

<img width="1280" height="764" alt="E2-2-2-7" src="https://github.com/user-attachments/assets/495f295b-315f-416e-a83a-498f882a5ca5" />

**8. 实现动态响应用户更改**

<img width="1280" height="764" alt="E2-2-2-8" src="https://github.com/user-attachments/assets/b6bb348b-360a-4356-8bab-09e12a81841b" />

---

### 任务 3：完成面向 AI 应用的 Compose 布局最终实现结果
*(项目文件夹：`E2-2-3LiteRTAIDemo`)*

#### 一、 界面划分为 4 大区域

1. **顶部状态栏**：显示应用标题 `LiteRT AI Demo`，同时预留了右侧的 MoreVert 更多操作入口。
2. **相机预览区**：采用深色圆角卡片设计，模拟 CameraX 相机实时预览画面。带有视觉层叠效果的 `READY` 状态指示标签，用于提示 AI 模型当前的状态。
3. **测试结果区**：采用卡片形式展示 AI 识别的详细数据，包含：模型名称 (Model)、识别结果 (Result)、置信度 (Confidence)、耗时 (Time)。
4. **操作按钮区**：采用底部导航栏样式实现核心交互：拍照识别 (Capture)、相册导入 (Gallery)、切换模型 (Model)、清空结果 (Clear)。

#### 二、 全局架构

1. **整体框架**：使用 Material 3 的 `Scaffold` 分离了顶部栏、底部操作区和主体内容区。
2. **主体内容排版**：外层使用 `Column` 组件将占位空间、预览区、结果区自上而下垂直线性排列，并通过 `horizontalAlignment = Alignment.CenterHorizontally` 保证居中对齐。
3. **预览区层叠布局**：相机预览区域使用了 `Box` 布局。底层是带圆角和深色背景的容器；居中对齐放置了相机图标和文字；右上角 (`Alignment.TopEnd`) 层叠放置了 `READY` 状态指示器。
4. **结果信息列表**：利用 `Surface` 包装成卡片，内部通过自定义的 `ResultItem` 组件渲染数据。`ResultItem` 内部使用 `Row` 布局，并通过 `Arrangement.SpaceBetween` 实现了标签居左、数值居右的对齐效果。
5. **底部操作区**：在 `bottomBar` 中使用 `Row` 水平排列自定义的 `BottomNavItem`，图标与文字的组合通过内部的 `Column` 实现。

**最终结果实现如下：**

<img width="1280" height="764" alt="E2-2-3" src="https://github.com/user-attachments/assets/51a15c1c-450b-4c5d-b170-9f63303b0e9f" />
