package com.spacecruiser.game.view.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.spacecruiser.game.SpaceCruiser;
import com.spacecruiser.game.model.GameModel;

/**
 * Game over screen to save user nick, score and date.
 */

public class GameOver extends ScreenAdapter {

    private SpaceCruiser game;
    private GameModel model;

    private Stage stage;


    public GameOver(SpaceCruiser game, GameModel model){
        this.game = game;
        this.model = model;
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        game.getBatch().begin();
        drawbackground();
        game.getBatch().end();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height){
        stage.getViewport().update(width,height);
    }

    @Override
    public void show(){
        this.stage = new Stage(new FitViewport(SpaceCruiser.MENU_VIEWPORT_WIDTH, SpaceCruiser.MENU_VIEWPORT_HEIGTH, new OrthographicCamera()));

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
    }


    private void drawbackground(){
        Texture background = game.getAssetManager().get("images/gameoverBackground.jpg");
        game.getBatch().draw(background,0,0,SpaceCruiser.MENU_VIEWPORT_WIDTH,SpaceCruiser.MENU_VIEWPORT_HEIGTH);
    }
}