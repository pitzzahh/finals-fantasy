# Finals Fantasy

Finals Fantasy is a battle game where two knights fight each other to the death. The game is developed in Java and provides a simple yet engaging command-line interface for the players.

### Prerequisites

- Java Development Kit (JDK) 8 or above

### Installation

#### Clone the repository to your local machine using the following command:

```bash
git clone https://github.com/pitzzahh/finals-fantasy.git
```
1. Compile the source code using the following sample command:

#### Sample tree structure
![structure.png](structure.png)

```bash
javac -encoding UTF-8 -d D:/finals-fantasy/out/ D:/finals-fantasy/src/*.java
```
![with-compiled-structure.png](with-compiled-structure.png)

#### Run the program using the following command:

```bash
java -classpath D:/finals-fantasy/out/ Main <optional_arguments>
```
| Argument              | Description                                                                           | Example            |
|-----------------------|---------------------------------------------------------------------------------------|--------------------|
| `colored`             | If present, the game will be colored.                                                 | `colored`          |
| `game-freeze=<value>` | Sets the game freeze time in milliseconds. If not present, the default value is 4000. | `game-freeze=5000` |
