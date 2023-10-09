package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import dao.USUARIOATVDAO;

import entity.USUARIO_ATV;

public class tela_inicial extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_cpf;
	private JTextField textField_sobrenome;
	private JTextField textField_email;
	private JTextField textField_idade;
	private JTextField textField_ano;

	private USUARIO_ATV usuario_ATV = new USUARIO_ATV();
	private USUARIOATVDAO usuarioatvdao = new USUARIOATVDAO();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_inicial frame = new tela_inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tela_inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_telainicial = new JLabel("Tela Inicial");
		jLabel_telainicial.setFont(new Font("Tahoma", Font.BOLD, 18));
		jLabel_telainicial.setBounds(330, 24, 100, 22);
		contentPane.add(jLabel_telainicial);
		
		JLabel jLabel_nome = new JLabel("Nome");
		jLabel_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel_nome.setBounds(46, 130, 46, 14);
		contentPane.add(jLabel_nome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(102, 129, 153, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel jLabel_cpf = new JLabel("CPF");
		jLabel_cpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel_cpf.setBounds(114, 195, 100, 14);
		contentPane.add(jLabel_cpf);
		
		textField_cpf = new JTextField();
		textField_cpf.setBounds(156, 194, 190, 20);
		contentPane.add(textField_cpf);
		textField_cpf.setColumns(10);
		
		JLabel jLabel_sobrenome = new JLabel("Sobrenome");
		jLabel_sobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel_sobrenome.setBounds(299, 130, 78, 14);
		contentPane.add(jLabel_sobrenome);
		
		textField_sobrenome = new JTextField();
		textField_sobrenome.setBounds(387, 129, 153, 20);
		contentPane.add(textField_sobrenome);
		textField_sobrenome.setColumns(10);
		
		JLabel jLabel_email = new JLabel("E-mail");
		jLabel_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel_email.setBounds(434, 195, 46, 14);
		contentPane.add(jLabel_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(490, 194, 190, 20);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel jLabel_idade = new JLabel("Idade");
		jLabel_idade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel_idade.setBounds(577, 130, 46, 14);
		contentPane.add(jLabel_idade);
		
		textField_idade = new JTextField();
		textField_idade.setBounds(633, 129, 86, 20);
		contentPane.add(textField_idade);
		textField_idade.setColumns(10);
		
		JLabel jLabel_ano = new JLabel("Ano do Cadastro");
		jLabel_ano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel_ano.setBounds(224, 261, 113, 14);
		contentPane.add(jLabel_ano);
		
		textField_ano = new JTextField();
		textField_ano.setBounds(347, 260, 86, 20);
		contentPane.add(textField_ano);
		textField_ano.setColumns(10);
		
		JButton btn_cadastrar = new JButton("Cadastrar");

		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				usuario_ATV.setCpf(textField_cpf.getText());
				usuario_ATV.setNome(textField_nome.getText());
				usuario_ATV.setSobrenome(textField_sobrenome.getText());
				usuario_ATV.setIdade(Integer.parseInt(textField_idade.getText()));
				usuario_ATV.setEmail(textField_email.getText());
				usuario_ATV.setAno(Integer.parseInt(textField_ano.getText()));

				usuarioatvdao.cadastrarUsuario(usuario_ATV);



			
			}
		}
			
	);
		btn_cadastrar.setBounds(102, 351, 129, 23);
		contentPane.add(btn_cadastrar);
		
		JButton btn_buscar = new JButton("Buscar");

		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario_ATV.setCpf(textField_cpf.getText());
				usuarioatvdao.buscarUsuario(usuario_ATV);

				textField_nome.setText(usuario_ATV.getNome());
				textField_sobrenome.setText(usuario_ATV.getSobrenome());
				textField_idade.setText(Integer.toString(usuario_ATV.getIdade()));
				textField_email.setText(usuario_ATV.getEmail());
				textField_ano.setText(Integer.toString(usuario_ATV.getAno()));
				

			}
		
		}

		);


		btn_buscar.setBounds(259, 351, 129, 23);
		contentPane.add(btn_buscar);
		
		
		JButton btn_atualizar = new JButton("Atualizar");
	btn_atualizar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Obtém o valor do CPF do campo de texto
        String cpf = textField_cpf.getText(); 

        if (!cpf.isEmpty()) {
            // Define o CPF no objeto usuario_ATV
            usuario_ATV.setCpf(cpf);

            // Define os novos valores a serem atualizados
            usuario_ATV.setNome(textField_nome.getText());
            usuario_ATV.setSobrenome(textField_sobrenome.getText());
            
            try {
                // Converte os valores dos campos de idade e ano para int (faça tratamento de erros apropriado)
                int idade = Integer.parseInt(textField_idade.getText());
                usuario_ATV.setIdade(idade);

                int ano = Integer.parseInt(textField_ano.getText());
                usuario_ATV.setAno(ano);

                // Define o valor do campo de email
                usuario_ATV.setEmail(textField_email.getText());

                // Chama o método atualizarUsuario no seu DAO
                USUARIOATVDAO.atualizarUsuario(usuario_ATV);

                // Limpa os campos após a atualização 
                textField_nome.setText("");
                textField_sobrenome.setText("");
                textField_idade.setText("");
                textField_email.setText("");
                textField_ano.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Idade ou ano inválido. Certifique-se de inserir valores numéricos.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "CPF inválido ou em branco. Tente novamente.");
        }
    }
});

btn_atualizar.setBounds(416, 351, 124, 23);
contentPane.add(btn_atualizar);


btn_atualizar.setBounds(416, 351, 124, 23);
contentPane.add(btn_atualizar);
	

		
		
		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = textField_cpf.getText();
				USUARIOATVDAO.excluirUsuario(usuario_ATV);

			}
		}
		);
		btn_excluir.setBounds(558, 351, 122, 23);
		contentPane.add(btn_excluir);
		
	
}
}
