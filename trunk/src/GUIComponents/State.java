
package GUIComponents;

/**
 *
 * @author Jere
 */
public class State {

    public static enum MenuState {

        NEWGAME,
        RESUME,
        SP,
        MP,
        MAINMENU,
        CLIENT,
        HOST,
        QUIT,
        NULL
    }
    public static MenuState state = MenuState.NULL;

}
