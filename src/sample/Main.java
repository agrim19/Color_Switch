package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Player P = new Player();
        P.start(primaryStage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}

class Player{
    public void start(Stage primaryStage) throws IOException{
        Game G = new Game();
        G.start(primaryStage);
    }
}

class Game extends Main{
    public void start (Stage primaryStage)throws IOException
    {
        this.play(primaryStage);
    }
    private void resume(){
        //show saved games
        //choose saved game
        //savedGame.start()
    }
    private void play(Stage primaryStage) throws IOException{
        //start new game
        Scene menu,game,titleScreen,splashScreen,mainMenu,enterName,startGame,resumeScreen;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Label label1 = new Label("COLOR GAME");
        Button start = new Button("Start");

//        Circular circle = new Circular();
//        Group root = circle.show(300.0f,100.0f,70.0f,56.0f);
//        circle.move(root,360);
//
//        Square square = new Square();
//        Group root = square.show(100.0f,150.0f,110.0f,110.0f);
//        square.move(root,360);
//
//        Plus plus = new Plus();
//        Group root = plus.show(200.0f,300.0f,70.0f);
//        plus.move(root,360);
//
        HorizontalLine horizontalLine = new HorizontalLine();
        Group root = horizontalLine.show(10.0f,75.0f);
        horizontalLine.move(root);

//        VerticalLine verticalLine = new VerticalLine();
//        Group root5[] = verticalLine.show();
//        verticalLine.moveRight(root5[0]);
//        verticalLine.moveLeft(root5[1]);
//        StackPane stack = new StackPane(root5[0],root5[1]);
//        HBox hbox = new HBox(root5[0],root5[1]);


        VBox layout1 = new VBox(50);
        layout1.getChildren().addAll(label1,start,root);
        layout1.setStyle("-fx-background-color: #282828");
        menu = new Scene(layout1,300,500);

        Button exit = new Button("Exit");
        exit.setOnAction(e->primaryStage.setScene(menu));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(exit);
        layout1.setStyle("-fx-background-color: #282828");
        game = new Scene(layout2,300,500);
        start.setOnAction(e->primaryStage.setScene(game));

//        startGame = startGame();

//        mainMenu = mainMenu();
//
//        enterName = enterName();
//        pauseTransition(primaryStage,mainMenu,20);
//
//        splashScreen = splashScreen();
//        pauseTransition(primaryStage,enterName,10);
//
//        titleScreen = titleImage();
//        pauseTransition(primaryStage,splashScreen,2);

        resumeScreen = resumeGame();

        primaryStage.setScene(resumeScreen);
        primaryStage.setTitle("Color Switch");
        primaryStage.show();
    }

    private Scene resumeGame(){
        Line line = new Line(0,0,300,0);
        line.setStrokeWidth(140);
        line.setStroke(Color.valueOf("#e53e7b"));
        HBox hbox = new HBox();
        for(int i=0;i<18;i++){
            hbox.getChildren().add(new Circle(300.0f,100.0f,10.f,Color.valueOf("#e53e7b")));
        }

        Text text = new Text("SAVED GAMES");
        text.getStyleClass().add("headerText");

        Pane pane = new Pane(line,hbox);
        pane.setStyle("-fx-background-color: #282828");
        hbox.relocate(0,60);
        StackPane stackPane = new StackPane(pane,text);
        return new Scene(stackPane,300,500);
    }

    private Scene startGame() throws IOException{
        ColorChanger colorChanger = new ColorChanger();
        Group root = colorChanger.show(10,10);

        Star star = new Star();
        ImageView starImage = star.show();

        Diamond diamond = new Diamond();
        Group dia = diamond.show();

        VBox stackPane = new VBox();
        stackPane.getChildren().addAll(root,starImage,dia);
        stackPane.setStyle("-fx-background-color: #282828");
        return new Scene(stackPane,300,500);
    }

    private Scene enterName() throws IOException{
        Text text = new Text("Enter Name");
        text.setId("text");
        TextField name = new TextField();
        name.setId("textField");
        name.setMinSize(180,40);
        name.setAlignment(Pos.CENTER);
        Button next = new Button("NEXT");
        next.setId("nextBtn");

        Image image = new Image(new FileInputStream("src/ShortTitleImage.jpg"));
        ImageView titleImage = new ImageView(image);
        titleImage.setFitWidth(250);
        titleImage.setPreserveRatio(true);

        GridPane grid = new GridPane();
        grid.setMinSize(300, 500);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(20);
        grid.setHalignment(text, HPos.CENTER);
        grid.setHalignment(next, HPos.CENTER);
        grid.add(titleImage,1,3);
        grid.add(text, 1, 13);
        grid.add(name, 1, 17);
        grid.add(next,1,21);
        grid.setStyle("-fx-background-color: #282828");
        Scene scene =  new Scene(grid,300,500);
        scene.getStylesheets().add("Theme.css");
        return scene;
    }

    private Scene mainMenu() throws IOException{
        Group root = circleAnimation();
        Button start = new Button("START");
        Button resume = new Button("RESUME");
        Button exit = new Button("EXIT");
        GridPane grid = new GridPane();
        grid.setMinSize(300, 500);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER);
        grid.add(root, 1, 2);
        grid.add(start, 1, 8);
        grid.add(resume,1,10);
        grid.add(exit,1,12);
        grid.setStyle("-fx-background-color: #282828");
        grid.setHalignment(start, HPos.CENTER);
        grid.setHalignment(resume,HPos.CENTER);
        grid.setHalignment(exit,HPos.CENTER);
        Scene scene = new Scene(grid,300,500);
        start.getStyleClass().add("button");
        resume.getStyleClass().add("button");
        exit.getStyleClass().add("button");
        scene.getStylesheets().add("Theme.css");
        return scene;
    }

    private Group circleAnimation() throws FileNotFoundException,IOException {
        Circular outer = new Circular();
        Group root = outer.show(300.0f,100.0f,120.0f,100.0f);
        outer.move(root,360);
        Circular middle = new Circular();
        Group root2 = middle.show(300.0f,100.0f,95.0f,80.0f);
        middle.move(root2,-360);
        Circular inner = new Circular();
        Group root3 = inner.show(300.0f,100.0f,75.0f,60.0f);
        inner.move(root3,360);
        Image image = new Image(new FileInputStream("src/Triangle.jpg"));
        ImageView triangleImage = new ImageView(image);
        triangleImage.setFitWidth(70);
        triangleImage.setX(270);
        triangleImage.setY(64);
        triangleImage.setPreserveRatio(true);
        Circle circle = new Circle(300.0f,100.0f,55.f,Color.valueOf("#585858"));
        return new Group(root,root2,root3,circle,triangleImage);
    }

    private void pauseTransition(Stage primaryStage,Scene nextScene,int time){
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(time));
        pauseTransition.setOnFinished( event -> primaryStage.setScene(nextScene) );
        pauseTransition.play();
    }

    private Scene splashScreen(){
        Circular circle = new Circular();
        Group root = circle.show(30.0f,50.0f,70.0f,56.0f);
        root.setLayoutX(121);
        root.setLayoutY(140);
        circle.move(root,360);
        Ball ball = new Ball();
        Circle b = ball.show();
        b.setCenterX(150);
        b.setCenterY(450);
        Pane layout = new Pane();
        layout.getChildren().add(root);
        layout.getChildren().add(b);
        layout.setStyle("-fx-background-color: #292929");
        Path path = new Path();
        path.getElements().add(new MoveTo(b.getCenterX(), b.getCenterY()));
        path.getElements().add(new CubicCurveTo(b.getCenterX(), b.getCenterY(), b.getCenterX(), 120, b.getCenterX(), 450));
        path.getElements().add(new CubicCurveTo(b.getCenterX(), b.getCenterY(), b.getCenterX(), 120, b.getCenterX(), 450));
        path.getElements().add(new CubicCurveTo(b.getCenterX(), b.getCenterY(), b.getCenterX(), 120, b.getCenterX(), 450));
        path.getElements().add(new CubicCurveTo(b.getCenterX(), b.getCenterY(), b.getCenterX(), 120, b.getCenterX(), 450));
        path.getElements().add(new CubicCurveTo(b.getCenterX(), b.getCenterY(), b.getCenterX(), 250, b.getCenterX(), 450));
        path.getElements().add(new CubicCurveTo(b.getCenterX(), 450, b.getCenterX(), 187, b.getCenterX(), 187));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4250));
        pathTransition.setPath(path);
        pathTransition.setNode(b);
        pathTransition.play();
        return new Scene(layout,300,500);
    }

    private Scene titleImage() throws IOException{
        Image image = new Image(new FileInputStream("src/TitleImage.jpg"));
        ImageView titleImage = new ImageView(image);
        titleImage.setFitWidth(300);
        titleImage.setPreserveRatio(true);
        StackPane layout = new StackPane();
        layout.getChildren().add(titleImage);
        layout.setStyle("-fx-background-color: #292929");
        return new Scene(layout,300,500);
    }
}

class Ball extends Game{
    Ball(){

    }
    public Circle show(){
        Circle circle = new Circle(10.f,Color.valueOf("#f7f7f7"));
        return circle;
    }
}

class Reward extends Game{
}

class Star extends Game{
    public ImageView show() throws IOException{
        Image image = new Image(new FileInputStream("src/star.jpg"));
        ImageView star = new ImageView(image);
        star.setFitWidth(40);
        star.setPreserveRatio(true);
        return star;
    }
}

class Diamond extends Game{
    public Group show(){
        Rectangle dia = new Rectangle(50,50,23,23);
        dia.setArcWidth(3);
        dia.setArcHeight(2);
        dia.setFill(Color.valueOf("#f7f7f7"));
        Rotate rotate = new Rotate(52);
        Shear shear = new Shear();
        shear.setX(0.3);
        dia.getTransforms().addAll(rotate,shear);
        Group group = new Group(dia);
        return group;
    }
}

class ColorChanger extends Game{
    private final float radius;
    ColorChanger(){
        this.radius = 13;
    }
    public Group show(float x,float y){
        float angle = 0.0f;
        Arc arcs[] = new Arc[4];

        Paint paint[] = {Color.valueOf("#e53e7b"),Color.valueOf("#8a49ef"),Color.valueOf("#eed948"),Color.valueOf("#5edcea")};
        for(int i=0;i<4;i++){
            arcs[i] = new Arc(x,y,radius,radius,angle,90.0f);

            arcs[i].setType(ArcType.ROUND);
            arcs[i].setFill(paint[i]);
            angle+=90.0f;
        }
        Group root = new Group(arcs[0],arcs[1],arcs[2],arcs[3]);
        return root;
    }
}

class Obstacles extends Game{}

class Linear extends Obstacles{
    public void move(Group root){
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(-600);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(root);
        translate.play();
    }

    public void moveLeft(Group root){
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(-300);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(root);
        translate.play();
    }

    public  void moveRight(Group root){
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(300);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(root);
        translate.play();
    }
}

class VerticalLine extends Linear{
    private final int strokeWidth;

    VerticalLine(){
        this.strokeWidth=10;
    }

    public Group[] show(){
        Rectangle rectangle1 = new Rectangle(60.0f,75.0f,12.0f,100.0f);
        rectangle1.setArcHeight(15.02);
        rectangle1.setArcWidth(30.02);
        rectangle1.setFill(Color.valueOf("#e53e7b"));

        Rectangle rectangle2 = new Rectangle(180.0f,75.0f,12.0f,100.0f);
        rectangle2.setArcHeight(15.02);
        rectangle2.setArcWidth(30.02);
        rectangle2.setFill(Color.valueOf("#eed948"));

        Rectangle rectangle3 = new Rectangle(120,90.0f,8.0f,70.0f);
        rectangle3.setArcHeight(15.02);
        rectangle3.setArcWidth(30.02);
        rectangle3.setFill(Color.valueOf("#8a49ef"));

        Rectangle rectangle4 = new Rectangle(240,90.0f,8f,70.0f);
        rectangle4.setArcHeight(15.02);
        rectangle4.setArcWidth(30.02);
        rectangle4.setFill(Color.valueOf("#5edcea"));

        Rectangle rectangle5 = new Rectangle(40.0f,90.0f,8f,70.0f);
        rectangle5.setArcHeight(15.02);
        rectangle5.setArcWidth(30.02);
        rectangle5.setFill(Color.valueOf("#e53e7b"));

        Rectangle rectangle6 = new Rectangle(160.0f,90.0f,8f,70.0f);
        rectangle6.setArcHeight(15.02);
        rectangle6.setArcWidth(30.02);
        rectangle6.setFill(Color.valueOf("#8a49ef"));

        Rectangle rectangle7 = new Rectangle(100.0f,100.0f,6f,50.0f);
        rectangle7.setArcHeight(15.02);
        rectangle7.setArcWidth(30.02);
        rectangle7.setFill(Color.valueOf("#eed948"));

        Rectangle rectangle8 = new Rectangle(220.0f,100.0f,6f,50.0f);
        rectangle8.setArcHeight(15.02);
        rectangle8.setArcWidth(30.02);
        rectangle8.setFill(Color.valueOf("#5edcea"));

        Group root1 = new Group(rectangle1,rectangle2,rectangle3,rectangle4);
        Group root2 = new Group(rectangle5,rectangle6,rectangle7,rectangle8);
        Group arr[] ={root1,root2};
        return arr;
    }
}

class HorizontalLine extends Linear{
    private final int strokeWidth;

    HorizontalLine(){
        this.strokeWidth=10;
    }

    public Group show(float y,float len){

        Line lines[] = new Line[12];
        Paint paint[] = {Color.valueOf("#e53e7b"),Color.valueOf("#8a49ef"),Color.valueOf("#eed948"),Color.valueOf("#5edcea")};

        for(int i=-4;i<8;i++){
            lines[i+4] = new Line(i*len,y,(i+1)*len,y);
            lines[i+4].setStrokeWidth(strokeWidth);
            lines[i+4].setStroke(paint[Math.abs(i%4)]);
        }

        Group root = new Group(lines[0],lines[1],lines[2],lines[3],lines[4],lines[5],lines[6],lines[7],lines[8],lines[9],lines[10],lines[11]);
        return root;
    }
}

class Rotating extends Obstacles{

    public void move(Group root,int angle){
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(angle);
        rotate.setCycleCount(1000);
        rotate.setDuration(Duration.millis(3500));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(root);
        rotate.play();
    }
}

class Plus extends Rotating{
    private final int strokeWidth;

    Plus(){
        this.strokeWidth=12;
    }

    public Group show(float centerx,float centery,float length){
        Line line1 = new Line(centerx,centery-length,centerx,centery);
        line1.setStrokeWidth(strokeWidth);
        line1.setStroke(Color.valueOf("#e53e7b"));

        Line line2 = new Line(centerx,centery,centerx,centery+length);
        line2.setStrokeWidth(strokeWidth);
        line2.setStroke(Color.valueOf("#8a49ef"));

        Line line3 = new Line(centerx,centery,centerx+length,centery);
        line3.setStrokeWidth(strokeWidth);
        line3.setStroke(Color.valueOf("#eed948"));

        Line line4 = new Line(centerx-length,centery,centerx,centery);
        line4.setStrokeWidth(strokeWidth);
        line4.setStroke(Color.valueOf("#5edcea"));

        Group root = new Group(line1,line2,line3,line4);
        return root;
    }
}

class Square extends Rotating{
    private final int strokeWidth;

    Square(){
        this.strokeWidth=15;
    }
    public Group show(float x,float y,float length,float breadth){

        Line line1 = new Line(x,y,x+length,y);
        line1.setStrokeWidth(strokeWidth);
        line1.setStroke(Color.valueOf("#e53e7b"));

        Line line2 = new Line(x,y+breadth,x+length,y+breadth);
        line2.setStrokeWidth(strokeWidth);
        line2.setStroke(Color.valueOf("#8a49ef"));

        Line line3 = new Line(x,y,x,y+breadth);
        line3.setStrokeWidth(strokeWidth);
        line3.setStroke(Color.valueOf("#eed948"));

        Line line4 = new Line(x+length,y,x+length,y+breadth);
        line4.setStrokeWidth(strokeWidth);
        line4.setStroke(Color.valueOf("#5edcea"));

        Group root = new Group(line1,line2,line3,line4);
        return root;
    }
}

class Circular extends Rotating{
    public Group show(float x,float y,float radiusOuter,float radiusInner){
        float angle = 0.0f;
        Shape arcs[] = new Shape[4];

        Paint paint[] = {Color.valueOf("#e53e7b"),Color.valueOf("#8a49ef"),Color.valueOf("#eed948"),Color.valueOf("#5edcea")};
        for(int i=0;i<4;i++){
            Arc arc1o = new Arc(x,y,radiusOuter,radiusOuter,angle,90.0f);
            Arc arc1i = new Arc(x,y,radiusInner,radiusInner,angle,90.0f);
            arc1o.setType(ArcType.ROUND);
            arc1i.setType(ArcType.ROUND);
            arcs[i] = Shape.subtract(arc1o,arc1i);
            arcs[i].setFill(paint[i]);
            arc1i.setFill(null);
            angle+=90.0f;
        }
        Group root = new Group(arcs[0],arcs[1],arcs[2],arcs[3]);
        return root;
    }
}