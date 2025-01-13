package com.example.examenjava;

import javafx.beans.binding.ListBinding;

import java.util.List;

public interface DAO<T> {
    public void ajouter();
    public void modifier();
    public void supprimer();
    public List<T> lire();
}
