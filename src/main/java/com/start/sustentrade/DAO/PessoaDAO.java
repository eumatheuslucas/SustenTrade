package com.start.sustentrade.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.start.sustentrade.MODEL.PessoaMODEL;
import com.start.sustentrade.MODEL.EmpresaMODEL;

//Classe do Usuario. Acesso do objeto ao usuário. Os comandos sql acontecem aqui.
public class PessoaDAO 
{
  Connection con;

  //Método de autenticação do usuário através do objUsuarioPessoaDto que recebe os gets and sets da tela de usuario.
  public ResultSet autenticacaoUsuario(PessoaMODEL objPessoaDto)
  {
    //Antes de fazer qualquer entrada sql é necessário a conexão como está sendo feita aqui.
    con = new ConexaoDAO().AbreBd();
    
    try
    {
       String sql = "select * from pessoas where nome = ? and senha = ?";
       
       PreparedStatement pstm = con.prepareStatement(sql);

      // No 1º ponto de interrogação ele pega o valor da variável nome e no 2º o valor da variável senha.
       pstm.setString(1,objPessoaDto.getNome_pessoa());
       pstm.setString(2,objPessoaDto.getSenha_pessoa());

       /**ResultSet promove métodos getters, ou seja, guarda resultados provenientes de uma query SQL através de um preparedStatement. 
          Aqui na variável rs do ResultSet é guardado a execução do método executeQuery que pede para fazer todo o processo com o pstm acima**/
      ResultSet rs = pstm.executeQuery();

       return rs;
    }
    catch(SQLException erro)
    {
      System.out.println("PessoaDAO Error! Message: " + erro);
      return null;
    }

  }





}