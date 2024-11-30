/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author azizb
 */
public class ModelTabelBengkel extends AbstractTableModel{
    
    private List<ModelBengkel> bengkelList;
    private String[] columnNames = {"NO", "NamaBarang", "Kategori", "Stok", "Harga"};
    
    public ModelTabelBengkel(List<ModelBengkel> bengkelList) {
        this.bengkelList = bengkelList;
    }
    
    @Override
    public int getRowCount() {
        return bengkelList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelBengkel bengkel = bengkelList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> bengkel.getNo();
            case 1 -> bengkel.getNamaBarang();
            case 2 -> bengkel.getKategori();
            case 3 -> bengkel.getStok();
            case 4 -> bengkel.getHarga();
            default -> null;
        };      
    }
    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // mengatur nama kolom
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // semua sel tidak dapat diedit
    }
    
    public void setBengkelList(List<ModelBengkel> bengkelList) {
        this.bengkelList = bengkelList;
        fireTableDataChanged(); // memberitahu JTable bahwa data telah berubah
    }
}

