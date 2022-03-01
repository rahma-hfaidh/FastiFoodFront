package com.example.testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class comRAdapter extends RecyclerView.Adapter<comRAdapter.ComViewHolder>{


    List<commandeRestau> listCom;
    Context context;

    public comRAdapter(List<commandeRestau> listCom, Context context) {
        this.listCom = listCom;
        this.context = context;
    }


    @NonNull
    @Override
    public ComViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lc_item_commande_rest, parent, false);
        comRAdapter.ComViewHolder comViewHolder = new comRAdapter.ComViewHolder(view);
        return comViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ComViewHolder holder, int position) {

        commandeRestau com = listCom.get(position);
        holder.modepaye.setText(com.getMode_payement());
        holder.date.setText(com.getDate().substring(0,10));
        holder.somme_com.setText(Double.toString(com.getSomme_fact()));
        holder.adresse.setText(com.getAdresse());
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.array_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner.setAdapter(adapter);

        int spinnerPosition = adapter.getPosition(com.getReponse());
        holder.spinner.setSelection(spinnerPosition);
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String chaine="en attent";
                String repo = String.valueOf(holder.spinner.getSelectedItem());
                // com.setReponse(String.valueOf(adapter.getItem(position)));
                if (position == 0) {
                    holder.spinner.setBackgroundResource(R.drawable.attent);
                    chaine="en attent";
                    Toast.makeText(context, "Selected : " + repo, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    chaine="accepté";
                    holder.spinner.setBackgroundResource(R.drawable.accept);
                    Toast.makeText(context, "Selected : " + repo, Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    chaine="refusé";
                    holder.spinner.setBackgroundResource(R.drawable.refuse);
                    Toast.makeText(context, "Selected : " + repo, Toast.LENGTH_SHORT).show();
                }
                ApiComR api = ApiClient.getClient().create(ApiComR.class);
                Call<String> putRep = (Call<String>) api.putRep(com.getId_fact(),chaine);

                putRep.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                        Toast.makeText(context,"reponse modifié ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(context,"reponse n'est pas modifié !", Toast.LENGTH_LONG).show();
                        // Toast.makeText(getApplicationContext(),"Probléme lors de l ajout ", Toast.LENGTH_LONG).show();
                    }
                });




              /*   ApiComR api = ApiClient.getClient().create(ApiComR.class);
                Call<ResponseBody> rep = api.putRep(com.getId_fact(), chaine);
                System.out.println(rep);

                rep.enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {

                                System.out.println("reppppppppppppppppppppp ");



                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });



                */


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listCom.get(position).getAdresse(), Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        {
            return listCom.size();
        }
    }


    public class ComViewHolder extends RecyclerView.ViewHolder {
        Spinner spinner;
        TextView adresse;
        TextView somme_com;
        TextView date;
        TextView modepaye;


        public ComViewHolder(@NonNull View itemView) {
            super(itemView);
            adresse = itemView.findViewById(R.id.adresseR);
            date = itemView.findViewById(R.id.dateR);
            somme_com = itemView.findViewById(R.id.somme_comR);
            modepaye = itemView.findViewById(R.id.modepayeR);
            spinner = itemView.findViewById(R.id.rl_submit_catR);



            // When user select a List-Item
        }




    }

}


