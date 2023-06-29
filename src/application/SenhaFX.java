package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SenhaFX extends Application {
	Label lblQtd = new Label("Quantidade de caracteres:");
	TextField txtQtd = new TextField();
	Label lblSenha = new Label("Nova Senha:");
	TextField txtSenha = new TextField();
	Button btnSenha = new Button("Gerar Senha");
	Button btnLimpar = new Button("Limpar");
	
	public StringBuilder GerarSenha(int n) {
		StringBuilder senha = new StringBuilder();
		
		for(int i = 0; i < n; i++ ) {
			int posicao = (int) (Math.random() * n);
			senha.append(posicao);
		}
		return senha;
	}
	
	public void Limpar() {
		txtQtd.clear();
		txtSenha.clear();
	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane painel = new GridPane();
		painel.setStyle("-fx-backgroud-color: grey");
		Scene scn = new Scene(painel);
		
		
		btnSenha.setOnAction(e->{
			StringBuilder novaSenha = GerarSenha(Integer.parseInt(txtQtd.getText()));
			txtSenha.setText(novaSenha.toString());
		});
		
		btnLimpar.setOnAction(e->{
			Limpar();
		});
		
		painel.add(lblQtd, 0, 0);
		painel.add(txtQtd, 1, 0);
		painel.add(lblSenha, 0, 4);
		painel.add(txtSenha, 1, 4);
		painel.add(btnSenha, 0, 2);
		painel.add(btnLimpar, 1, 2);
		
		painel.setVgap(10);
		painel.setHgap(10);
		
		stage.setScene(scn);
		stage.setWidth(350);
		stage.setHeight(200);
		stage.setTitle("Gerador de Senhas");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
