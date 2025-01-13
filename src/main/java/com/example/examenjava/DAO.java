package com.example.examenjava;

import javafx.beans.binding.ListBinding;

import java.util.List;

public interface DAO<T> {
    public void ajouter(T t);
    public void modifier(T t);
    public void supprimer(int id);
    public List<T> lire();
}
