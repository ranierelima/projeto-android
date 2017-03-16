package com.erroronserver.aplicativoprimeiroestagio.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erroronserver.aplicativoprimeiroestagio.MainActivity;
import com.erroronserver.aplicativoprimeiroestagio.R;
import com.erroronserver.aplicativoprimeiroestagio.model.Usuario;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.List;

/**
 * Created by Raniere de Lima - contato@erroronserver.com on 16/03/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private final List<Usuario> usuarios;
    private final Activity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto;
        public TextView nome;
        public ImageView telefone;

        public ViewHolder(View v) {
            super(v);
            nome = (TextView) v.findViewById(R.id.iv_i_rv_nome);
            telefone = (ImageView) v.findViewById(R.id.iv_i_rv_telefone);
            foto = (ImageView) v.findViewById(R.id.iv_i_rv_foto);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RVAdapter(List<Usuario> usuarios, Activity activity) {
        this.usuarios = usuarios;
        this.activity = activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {
        final Usuario usuario = usuarios.get(position);
        holder.nome.setText(usuario.getNome());
        Picasso.with(activity.getBaseContext()).load("http://api.adorable.io/avatars/"+position).into(holder.foto);
        holder.telefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + usuario.getTelefone())));
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}