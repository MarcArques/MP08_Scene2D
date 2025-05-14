package io.github.scene2d;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Main extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;

    @Override
    public void create() {
        // Crear Stage i Skin
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        Gdx.input.setInputProcessor(stage);

        // Crear taula per adaptar els elements
        Table table = new Table();
        table.setFillParent(true); // fa que ocupi tota la pantalla
        table.top().padTop(250); // deixar una mica d'espai a dalt
        stage.addActor(table);

        // Crear Label
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        Label label = new Label("Hola, això és un TextView", labelStyle);

        // Crear Button
        Button button = new TextButton("Clica'm!", skin);

        // Afegir a la taula
        table.add(label).padBottom(30);
        table.row(); // salt de línia
        table.add(button).width(200).height(50);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
