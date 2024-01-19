/*
 * MIT License
 *
 * Copyright (c) 2022 pitzzahh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

/**
 * Class used for coloring texts.
 */
public interface Colors {
    
    /**
     * Resets the text color.
     */
    String RESET = "\033[0m";  // Text Reset

    /**
     * Colors text as {@code BLACK}
     */
    String BLACK = "\033[0;30m";   // BLACK
    /**
     * Colors text as {@code RED}
     */
    String RED = "\033[0;31m";     // RED
    /**
     * Colors text as {@code GREEN}
     */
    String GREEN = "\033[0;32m";   // GREEN
    /**
     * Colors text as {@code YELLOW}
     */
    String YELLOW = "\033[0;33m";  // YELLOW
    /**
     * Colors text as {@code BLUE}
     */
    String BLUE = "\033[0;34m";    // BLUE
    /**
     * Colors text as {@code PURPLE}
     */
    String PURPLE = "\033[0;35m";  // PURPLE
    /**
     * Colors text as {@code CYAN}
     */
    String CYAN = "\033[0;36m";    // CYAN
    /**
     * Colors text as {@code WHITE}
     */
    String WHITE = "\033[0;37m";   // WHITE

    /**
     * Colors text as {@code BLACK_BOLD}
     */
    String BLACK_BOLD = "\033[1;30m";  // BLACK
    /**
     * Colors text as {@code RED_BOLD}
     */
    String RED_BOLD = "\033[1;31m";    // RED
    /**
     * Colors text as {@code GREEN_BOLD}
     */
    String GREEN_BOLD = "\033[1;32m";  // GREEN
    /**
     * Colors text as {@code YELLOW_BOLD}
     */
    String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    /**
     * Colors text as {@code BLUE_BOLD}
     */
    String BLUE_BOLD = "\033[1;34m";   // BLUE
    /**
     * Colors text as {@code PURPLE_BOLD}
     */
    String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    /**
     * Colors text as {@code CYAN_BOLD}
     */
    String CYAN_BOLD = "\033[1;36m";   // CYAN
    /**
     * Colors text as {@code WHITE_BOLD}
     */
    String WHITE_BOLD = "\033[1;37m";  // WHITE

    /**
     * Colors text as {@code BLACK_UNDERLINED}
     */
    String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    /**
     * Colors text as {@code RED_UNDERLINED}
     */
    String RED_UNDERLINED = "\033[4;31m";    // RED
    /**
     * Colors text as {@code GREEN_UNDERLINED}
     */
    String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    /**
     * Colors text as {@code YELLOW_UNDERLINED}
     */
    String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    /**
     * Colors text as {@code BLUE_UNDERLINED}
     */
    String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    /**
     * Colors text as {@code PURPLE_UNDERLINED}
     */
    String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    /**
     * Colors text as {@code CYAN_UNDERLINED}
     */
    String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    /**
     * Colors text as {@code WHITE_UNDERLINED}
     */
    String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    /**
     * Colors text background as {@code BLACK_BACKGROUND}
     */
    String BLACK_BACKGROUND = "\033[40m";  // BLACK
    /**
     * Colors text background as {@code RED_BACKGROUND}
     */
    String RED_BACKGROUND = "\033[41m";    // RED
    /**
     * Colors text background as {@code GREEN_BACKGROUND}
     */
    String GREEN_BACKGROUND = "\033[42m";  // GREEN
    /**
     * Colors text background as {@code YELLOW_BACKGROUND}
     */
    String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    /**
     * Colors text background as {@code BLUE_BACKGROUND}
     */
    String BLUE_BACKGROUND = "\033[44m";   // BLUE
    /**
     * Colors text background as {@code PURPLE_BACKGROUND}
     */
    String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    /**
     * Colors text background as {@code CYAN_BACKGROUND}
     */
    String CYAN_BACKGROUND = "\033[46m";   // CYAN
    /**
     * Colors text background as {@code WHITE_BACKGROUND}
     */
    String WHITE_BACKGROUND = "\033[47m";  // WHITE

    /**
     * Colors text as {@code BLACK_BRIGHT}
     */
    String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    /**
     * Colors text as {@code RED_BRIGHT}
     */
    String RED_BRIGHT = "\033[0;91m";    // RED
    /**
     * Colors text as {@code GREEN_BRIGHT}
     */
    String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    /**
     * Colors text as {@code YELLOW_BRIGHT}
     */
    String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    /**
     * Colors text as {@code BLUE_BRIGHT}
     */
    String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    /**
     * Colors text as {@code PURPLE_BRIGHT}
     */
    String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    /**
     * Colors text as {@code CYAN_BRIGHT}
     */
    String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    /**
     * Colors text as {@code WHITE_BRIGHT}
     */
    String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    /**
     * Colors text as {@code BLACK_BOLD_BRIGHT}
     */
    String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    /**
     * Colors text as {@code RED_BOLD_BRIGHT}
     */
    String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    /**
     * Colors text as {@code GREEN_BOLD_BRIGHT}
     */
    String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    /**
     * Colors text as {@code YELLOW_BOLD_BRIGHT}
     */
    String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    /**
     * Colors text as {@code BLUE_BOLD_BRIGHT}
     */
    String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    /**
     * Colors text as {@code PURPLE_BOLD_BRIGHT}
     */
    String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    /**
     * Colors text as {@code CYAN_BOLD_BRIGHT}
     */
    String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    /**
     * Colors text as {@code WHITE_BOLD_BRIGHT}
     */
    String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    /**
     * Colors text background as {@code BLACK_BACKGROUND_BRIGHT}
     */
    String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    /**
     * Colors text background as {@code RED_BACKGROUND_BRIGHT}
     */
    String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    /**
     * Colors text background as {@code GREEN_BACKGROUND_BRIGHT}
     */
    String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    /**
     * Colors text background as {@code YELLOW_BACKGROUND_BRIGHT}
     */
    String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    /**
     * Colors text background as {@code BLUE_BACKGROUND_BRIGHT}
     */
    String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    /**
     * Colors text background as {@code PURPLE_BACKGROUND_BRIGHT}
     */
    String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    /**
     * Colors text background as {@code CYAN_BACKGROUND_BRIGHT}
     */
    String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    /**
     * Colors text background as {@code WHITE_BACKGROUND_BRIGHT}
     */
    String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

    String[] COLORS = {
            RED,
            GREEN,
            YELLOW,
            BLUE,
            PURPLE,
            CYAN,
            WHITE
    };
}