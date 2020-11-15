/**
 * $  java.awt.event.WindowListener 1.1
 *      void windowOpened(WindowEvent e);
 *###  窗口打开后调用这个方法
 *
 *      void windowClosing(WindowEvent e);
 *###  在用户向窗口管理器发出关闭窗口是调用这个方法
 *
 *      void windowClosed(WindowEvent e);
 *###  窗口关闭后调用这个方法
 *
 *      void windowIconified(WindowEvent e);
 *###  窗口图标话后调用这个方法
 *
 *      void windowDeiconified(WindowEvent e);
 *###  窗口非图标化后调用这个方法
 *
 *      void windowActivated(WindowEvent e);
 *###  激活窗口后调用这个方法
 *
 *      void windowDeactivated(WindowEvent E);
 *###  窗口变为未激活状态后调用这个方法
 */

/**
 * $  java.awt.event.WindowStateListener 1.4
 *      void windowStateChanged(WindowEvent e);
 *###  窗口极大化、图标化、恢复正常大小时调用这个方法
 */

/**
 * $  java.awt.event.WindowEvent 1.1
 *      int getNewState();
 *      int getOldState();
 *###  返回窗口状态改变事件中窗口的新、旧状态。
 *                  将返回以下类型:
 *                  Frame.NORMAL
 *                  Frame.ICONIFIED
 *                  Frame.MAXIMIZED_HAFIZ
 *                  Frame.MAXIMIZED_VERT
 *                  Frame.MAXIMIZED_BOTH
 *                  Frame.MAXIMIZED_HERTZ
 *                  Frame.MAXIMIZED_HOPI
 *                  Frame.MAXIMIZED_HOPIS
 *                  Frame.MAXIMIZED_HOPING
 *                  Frame.MAXIMIZED_HOPI'S
 *                  Frame.MAXIMIZED_HOBIE
 */

/**
 * 焦点
 * $  java.awt.Component 1.0
 *      void requestFocus();
 *###  请求组件获得焦点
 *
 *      boolean requestFocusInWindow() 1.4
 *###  请求组件获得焦点。如果该组件没有包含在焦点窗口内，返回true，或者请求由于其他原因没有实现，返回false。
 *
 *      void setFocusable(boolean b) 1.4
 *      boolean isFocusable() 1.4
 *###  设置或获取组件的“focusable”状态。如果b为true，则该组件可以获得焦点。
 *
 *      boolean isFocusOwner（） 1.4
 *###  如果该组件当前拥有焦点，返回true。
 *
 * $  java.awt.KeyboardFocusManager 1.4
 *      static KeyboardFocusManager getCurrentKeybordFocusManager();
 *###  获得当前焦点管理器
 *
 *      Component getFocusOwner();
 *###  得到拥有焦点的组件，如果焦点管理器没有管理拥有焦点的组件，返回null。
 *
 *      Window getFocusWindow();
 *###  得到包含拥有焦点组件的窗口，如果焦点管理器没有管理拥有焦点的组件，返回null。
 *
 *      Window getActiveWindow();
 *###  得到对话框或包含焦点窗口的框架，如果焦点管理器没有管理焦点窗口，返回null。
 *
 * $  java.awt.Window() 1.0
 *      boolean isFocused();
 *###  如果该窗口是焦点窗口，返回true
 *
 *      boolean isActive(); 1.4
 *###  如果该框架或对话框是当前的活动窗口，返回true。活动框架和对话框的标题栏通常由焦点管理器标识出来。
 *
 * $  java.awt.event.FocusEvent 1.1
 *      Component getOppositeComponent() 1.4
 *###  返回focusGained处理器中失去焦点的组件，或者在focusLost处理器中获得焦点的组件。
 *
 * $  java.awt.event.WindowEvent 1.4
 *      Window getOppositeWindow();
 *###  返回在windowGainedFocus处理器中失去焦点的窗口，在windowLostFocus处理器中获得焦点的窗口，在windowActivated处理器中变为不活动的窗口，在windowDeactivated处理器中被激活的窗口。
 *
 * $  java.awt.event.WindowFocusListener 1.4
 *      void windowGainedFocus(WindowEvent event);
 *###  当事件源窗口获得焦点是时调用该方法。
 *
 *      void windowLostFocus(WindowEvent event);
 *###  当事件源窗口失去焦点时调用该方法。
 */

/**
 *
 */