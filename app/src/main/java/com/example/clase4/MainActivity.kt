package com.example.clase4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recView: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView = findViewById(R.id.recycleView)
        recView.layoutManager = LinearLayoutManager(this)
        val dataSet = getListadoEquipo()
        adapter = Adapter(applicationContext)
        recView.adapter = adapter
        adapter.submitList(dataSet)
        adapter.onItemClickListener = {
            /*val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("imagen", it.url)
            startActivity(intent)

             */
        }
    }

        private fun getListadoEquipo(): MutableList<Equipo>? {
            return mutableListOf(
                Equipo(
                    1,
                    "River",
                    "Millonario",
                    "Monumental",
                    "https://en.wikipedia.org/wiki/Club_Atl%C3%A9tico_River_Plate#/media/File:Escudo_del_C_A_River_Plate.svg",
                    Pais.Argentina
                ),
                Equipo(
                    2,
                    "Boca",
                    "Xeneize",
                    "Bombonera",
                    "https://es.wikipedia.org/wiki/Club_Atl%C3%A9tico_Boca_Juniors#/media/Archivo:CABJ70.png",
                    Pais.Argentina
                ),
                Equipo(
                    3,
                    "Liverpool",
                    "Cuchilla",
                    "Belvedere",
                    "https://es.wikipedia.org/wiki/Liverpool_F%C3%BAtbol_Club#/media/Archivo:Liverpoolchamp.png",
                    Pais.Uruguay
                ),
                Equipo(
                    4,
                    "Junior",
                    "Tiburon",
                    "Metropolitano Roberto Melendez",
                    "https://en.wikipedia.org/wiki/Atl%C3%A9tico_Junior#/media/File:ESCUDO_JUNIOR.svg",
                    Pais.Colombia
                ),
                Equipo(
                    5,
                    "Once Caldas",
                    "Albos",
                    "Palogrande",
                    "https://es.wikipedia.org/wiki/Once_Caldas#/media/Archivo:Logo_Once_Caldas.png",
                    Pais.Colombia
                ),
                Equipo(
                    6,
                    "Pasto",
                    "Volcanicos",
                    "Departamental Libertad",
                    "https://es.wikipedia.org/wiki/Deportivo_Pasto#/media/Archivo:Deportivo_Pasto_logo.png",
                    Pais.Colombia
                ),
                Equipo(
                    7,
                    "Colo-Colo",
                    "Cacique",
                    "Monumental",
                    "https://es.wikipedia.org/wiki/Club_Social_y_Deportivo_Colo-Colo#/media/Archivo:Escudo_de_Colo-Colo_1947.svg",
                    Pais.Chile
                ),
                Equipo(
                    8,
                    "Universidad Catolica",
                    "Cruzados",
                    "San Carlos de Apoquindo",
                    "https://es.wikipedia.org/wiki/Club_Deportivo_Universidad_Cat%C3%B3lica_(f%C3%BAtbol)#/media/Archivo:Escudo_Club_Deportivo_Universidad_Cat%C3%B3lica.svg",
                    Pais.Chile
                ),
                Equipo(
                    9,
                    "Fluminense",
                    "Flu",
                    "Maracana",
                    "https://es.wikipedia.org/wiki/Fluminense_Football_Club#/media/Archivo:Fluminense_FC_escudo.png",
                    Pais.Brasil
                ),
                Equipo(
                    10,
                    "Corinthians",
                    "Time Do Povo",
                    "Neo Quimica Arena",
                    "https://en.wikipedia.org/wiki/Sport_Club_Corinthians_Paulista#/media/File:Sport_Club_Corinthians_Paulista_crest.svg",
                    Pais.Brasil
                ),
            )
        }
    }
