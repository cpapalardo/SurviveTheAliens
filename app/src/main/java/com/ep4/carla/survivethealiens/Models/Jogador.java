package com.ep4.carla.survivethealiens.Models;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Jogador {
    private Integer id;
    private String nome;
    private String apelido;
    private Character genero;
    private String email;
    private String senha;
    private Date dataCadastro;
    private Integer horasJogadas;
    private Integer kmCaminhados;

    public Jogador(){

    }

    public Jogador(String _email, String _senha){
        email = _email;
        senha = _senha;
    }

    public Jogador(Parcel in){
        setApelido(in.readString());
        //setDataCadastro((Date)in.readSerializable());
        setDataCadastro(new Date(in.readLong()));
        setEmail(in.readString());
        setGenero(in.readString().charAt(0));
        setHorasJogadas(in.readInt());
        setId(in.readInt());
        setKmCaminhados(in.readInt());
        setNome(in.readString());
        setSenha(in.readString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getHorasJogadas() {
        return horasJogadas;
    }

    public void setHorasJogadas(int horasJogadas) {
        this.horasJogadas = horasJogadas;
    }

    public int getKmCaminhados() {
        return kmCaminhados;
    }

    public void setKmCaminhados(int kmCaminhados) {
        this.kmCaminhados = kmCaminhados;
    }

/*    @Override
    public int describeContents() {
        return 0;
    }*/

/*    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(getApelido());
        //out.writeSerializable(getDataCadastro());
        //out.writeLong(date != null ? date.getTime() : -1);
        out.writeLong(getDataCadastro().getTime());
        out.writeString(getEmail());
        out.writeString(getGenero().toString());
        out.writeInt(getHorasJogadas());
        out.writeInt(getId());
        out.writeInt(getKmCaminhados());
        out.writeString(getNome());
        out.writeString(getSenha());
    }

    private void readFromParcel(Parcel in) {
        setApelido(in.readString());
        //setDataCadastro((Date)in.readSerializable());
        setDataCadastro(new Date(in.readLong()));
        setEmail(in.readString());
        setGenero(in.readString().charAt(0));
        setHorasJogadas(in.readInt());
        setId(in.readInt());
        setKmCaminhados(in.readInt());
        setNome(in.readString());
        setSenha(in.readString());
    }

    public static final Parcelable.Creator<Jogador> CREATOR = new Parcelable.Creator<Jogador>() {

        @Override
        public Jogador createFromParcel(Parcel in) {
            return new Jogador(in);
        }

        @Override
        public Jogador[] newArray(int size) {
            return new Jogador[size];
        }

    };*/
}
