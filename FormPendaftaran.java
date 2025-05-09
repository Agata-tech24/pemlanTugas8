import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPendaftaran extends JFrame {
    private JTextField namaField, tglLahirField, noDaftarField, noTelpField, alamatField, emailField;

    public FormPendaftaran() {
        setTitle("Form Pendaftaran Mahasiswa Baru");
        setSize(350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5)); // Tambah baris untuk tombol

        panel.add(new JLabel("Nama Lengkap:"));
        namaField = new JTextField();
        panel.add(namaField);

        panel.add(new JLabel("Tanggal Lahir:"));
        tglLahirField = new JTextField();
        panel.add(tglLahirField);

        panel.add(new JLabel("Nomor Pendaftaran:"));
        noDaftarField = new JTextField();
        panel.add(noDaftarField);

        panel.add(new JLabel("No. Telp:"));
        noTelpField = new JTextField();
        panel.add(noTelpField);

        panel.add(new JLabel("Alamat:"));
        alamatField = new JTextField();
        panel.add(alamatField);

        panel.add(new JLabel("E-mail:"));
        emailField = new JTextField();
        panel.add(emailField);

        // Tombol submit
        panel.add(new JLabel()); // Spacer
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void handleSubmit() {
        // Validasi
        if (namaField.getText().isEmpty() || tglLahirField.getText().isEmpty() ||
            noDaftarField.getText().isEmpty() || noTelpField.getText().isEmpty() ||
            alamatField.getText().isEmpty() || emailField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Konfirmasi
        int pilihan = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION) {
            // Tampilkan data
            String data = "Nama              : " + namaField.getText() +
                          "\nTanggal Lahir     : " + tglLahirField.getText() +
                          "\nNo. Pendaftaran   : " + noDaftarField.getText() +
                          "\nNo. Telp          : " + noTelpField.getText() +
                          "\nAlamat            : " + alamatField.getText() +
                          "\nE-mail            : " + emailField.getText();

            JTextArea textArea = new JTextArea(data);
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Data Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPendaftaran());
    }
}
