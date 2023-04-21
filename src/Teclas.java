import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

public class Teclas {

        private static volatile boolean wPressed = false;
        public static boolean isWPressed() {
            synchronized (Teclas.class) {
                return wPressed;
            }
        }

        public static void main(String[] args) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

                @Override
                public boolean dispatchKeyEvent(KeyEvent ke) {
                    synchronized (Teclas.class) {
                        switch (ke.getID()) {
                            case KeyEvent.KEY_PRESSED:
                                if (ke.getKeyCode() == KeyEvent.VK_KP_DOWN) {
                                    wPressed = true;
                                }
                                break;

                            case KeyEvent.KEY_RELEASED:
                                if (ke.getKeyCode() == KeyEvent.VK_KP_DOWN) {
                                    wPressed = false;
                                }
                                break;
                        }
                        return false;
                    }
                }
            });
        }
    }

