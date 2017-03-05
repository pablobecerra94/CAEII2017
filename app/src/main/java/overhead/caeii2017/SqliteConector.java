package overhead.caeii2017;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SqliteConector extends SQLiteOpenHelper {

    private String sqlCreate = "CREATE TABLE Speakers (name TEXT, SpeakerText TEXT)";

    public SqliteConector(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
        ContentValues speaker1 = new ContentValues();
        speaker1.put("name", "Marcela Riccillo");
        speaker1.put("SpeakerText", "Doctora en Ciencias de la Computación de la Universidad de Buenos " +
                "Aires, con especialización en Robótica e Inteligencia Artificial. " +
                "Su foco actual es la Robótica Humanoide en el mundo, estudia las " +
                "características de los principales robots, la historia de su evolución y el " +
                "análisis de sus comportamientos sociales (HRI). " +
                "Participó en grupos de investigación y tiene publicados trabajos en " +
                "congresos internacionales. Escribe en revistas de divulgación (como Muy " +
                "Interesante y Cómo Ves? de México) y dicta seminarios de Robótica en " +
                "universidades e institutos. " +
                "Invitada como oradora en TEDxRosario 2012 Argentina, TEDxBarcelona " +
                "2013 España, Campus Party México 2013 y AXIS México 2014 entre " +
                "otros. " +
                "Participa como jurado de competencias de robots en universidades y condujo por 2 temporadas una " +
                "columna sobre Robótica en radio. Fue profesora varios años en la Universidad de Buenos Aires. Lleva " +
                "varios años de estudio de Coreano, Japonés,Chino, Inglés, Alemán y Latín.");
        sqLiteDatabase.insert("Speakers", null, speaker1);

        ContentValues speaker2 = new ContentValues();
        speaker2.put("name", "Lino Barañao");
        speaker2.put("SpeakerText", "Recibido como Licenciado en Ciencias Quimicas y luego Doctor en " +
                "Ciencias Quimicas en la UBA, realizó diversos posgrados en instituciones " +
                "de renombre como ser el Instituto Max Planck. " +
                "Profecionalmente se desempeña como investigador principal del " +
                "CONICET en el Instituto de Biología y Medicina Experimental. En 2002 fue " +
                "parte del equipo que logro el nacimiento de la primer ternera clonada de " +
                "Iberoamérica alterada geneticamente para la produccion en leche de " +
                "hormona de crecimiento humano. " +
                "Entre sus azañas politicas se desempeño como Presidente de Tecnología " +
                "del CONICET entre 1999 y 2000, del 2003 al 2007 ocupó el cargo de " +
                "Presidente de la Agencia Nacional de Promoción Cientifica y Tecnología. " +
                "Desde el 2007 hasta la fecha es el Ministro de Ciencia, Tecnología e Innovación " +
                "Productiva de la Nación.");
        sqLiteDatabase.insert("Speakers", null, speaker2);

        ContentValues speaker3 = new ContentValues();
        speaker3.put("name", "Debora Giorgi");
        speaker3.put("SpeakerText", "Es Licenciada en Economía de la Universidad " +
                "Católica Argentina con Diploma de Honor. " +
                "Ex Secretaria de industria, comercio, minería " +
                "Fue directora del Centro de Estudios para las " +
                "Negociaciones Internacionales " +
                "(CENI) " +
                "A partir de 2005 fue Ministra de " +
                "Asuntos Agrarios y Producción " +
                "Ex Ministra de Industria");
        sqLiteDatabase.insert("Speakers", null, speaker3);


        ContentValues speaker4 = new ContentValues();
        speaker4.put("name", "Gino Tubaro");
        speaker4.put("SpeakerText", "Es inventor, fundador de Atomic Lab, donde se " +
                "encuentra innovaciones como “Libs”, una plataforma " +
                "para solicitar una prótesis 3D, un “braile dinamico” " +
                "que traduce texto a braile y muchas cosas más. Fue " +
                "reconocido por Barack Obama por sus proyectos. " +
                "Ganó premios de la OMPI (ONU). Fue “Alumni of the " +
                "month” internacional por parte del Departamento de " +
                "Estados de los Estados Unidos de forma mundial en " +
                "“reconocimiento a su liderazgo en crear innovadoras " +
                "soluciones para ayudar a las personas con " +
                "discapacidades a vivir sin límites”. Ganó el primer " +
                "premio de Una Idea para Cambiar la historia de The " +
                "History Channel.");
        sqLiteDatabase.insert("Speakers", null, speaker4);


        ContentValues speaker5 = new ContentValues();
        speaker5.put("name", "Andy Freire");
        speaker5.put("SpeakerText", "Andrés \"Andy\" Freire es el Ministro de Modernización, Innovación y " +
                "Tecnología y titular del Ente de Turismo de la Ciudad de Buenos Aires. " +
                "Es licenciado en Economía Magna Cum Laude por la Universidad " +
                "de San Andrés, Argentina, y realizó el Owner President Management " +
                "Program de la Escuela de Negocios de la Universidad de Harvard. " +
                "Junto a Santiago Bilinkis fundó y lideró Officenet, una empresa de " +
                "distribución de artículos de oficina en Latinoamérica, cuyo éxito fue caso " +
                "de estudio en varias universidades en todo el mundo. Más tarde, cofundó " +
                "Axialent, una consultora que ayuda a las mayores empresas del mundo a " +
                "alinear su cultura organizacional. Participó, en algunos casos como " +
                "inversor y en otros como miembro de junta, en distintas start ups, entre ellas Wanako, Coffice, Reed " +
                "Argentina, Restorando, The Mind Company, Estrella limited y Parque Austral. " +
                "Reconocido como “Emprendedor del año de Latinoamérica” (2001) por la Fundación Endeavor y " +
                "“Líder Global del Mañana” (2002) por el Foro Económico Mundial, también fue uno de los dos finalistas " +
                "premiados en el “World Young Business Achiever Award”, celebrado en Filipinas en 2002, y en 2008 fue " +
                "distinguido como “Joven Líder Global” entre más de 100 jóvenes empresarios por el Foro Económico " +
                "Mundial en Davos, Suiza.");
        sqLiteDatabase.insert("Speakers", null, speaker5);

        ContentValues speaker6 = new ContentValues();
        speaker6.put("name", "Miguel Galuccio");
        speaker6.put("SpeakerText", "Ingeniero en Petroleo del Instituto Tecnológico de Buenos Aires (ITBA). Ex " +
                "CEO de YPF. " +
                "Es un experto en la localización y perforación para hallar petróleo, lo que " +
                "se conoce como \"reservorista\". A pesar de su corta edad, tiene una " +
                "experiencia confiable en todos los continentes y un alto grado de " +
                "especialización en la profesión.");
        sqLiteDatabase.insert("Speakers", null, speaker6);

        ContentValues speaker7 = new ContentValues();
        speaker7.put("name", "Cecilia Smoglie");
        speaker7.put("SpeakerText", "Licenciada en Física (Instituto Balseiro, abanderada, 1977), Postgrado " +
                "en Ingeniería Nuclear (Universidad de Londres, 1982) y Doctora en " +
                "Ingeniería Mecánica (Universidad de Karlsruhe, 1984). Fue Profesora " +
                "Adjunta de Termodinámica en el Instituto Balseiro (1985-88), " +
                "Investigadora de la CNEA, Investigadora Invitada en el Centro Atómico " +
                "Karlsruhe (1988-90), Ingeniera de Desarrollo para centrales eléctricas en " +
                "Asea Brown Boveri (Suiza, 1990-96), e Instructora de ASME en temas de " +
                "intercambiadores de calor. Desde 1996 se desempeña en el Instituto " +
                "Tecnológico de Buenos Aires, donde es Profesora Titular de " +
                "Termodinámica y de Transferencia de Calor, fue Directora de Ingeniería Mecánica e Ingeniería Naval " +
                "(1996-2010) y desde 2011 es Directora del Área de Energía. Su principal interés es la cooperación entre " +
                "universidad - empresa. Tiene 22 trabajos escritos para la Industria, 14 publicaciones y 3 patentes.");
        sqLiteDatabase.insert("Speakers", null, speaker7);

        ContentValues speaker8 = new ContentValues();
        speaker8.put("name", "Alejandro Ceccatto");
        speaker8.put("SpeakerText", "Realizó sus estudios en la Universidad Nacional de Rosario como " +
                "Licenciado en Física recibiendose en 1979. En 1985 culmina con " +
                "su doctorado en Fisica en la Universidad Nacional de La Plata, " +
                "dando lugar luego a dos Posdoctorados en la Universidad de " +
                "Colonia (Alemania) y la Universidad de Standford (USA). " +
                "En la actualidad participa como Investigador principal en el CONICET " +
                "ademas de ser miembro asociado del Centro Internacional de " +
                "Fisica Teorica (Triesta, Italia). Además desde 2008 es el " +
                "Secretario de Articulacíón Cientifico Tecnologico del Ministerio de " +
                "Ciencia, Tecnología e Innovación Productiva.");
        sqLiteDatabase.insert("Speakers", null, speaker8);

        ContentValues speaker9 = new ContentValues();
        speaker9.put("name", "Graciela Chichilnisky");
        speaker9.put("SpeakerText", "Doctora en Matemáticas recibida en la " +
                "Universidad de California. " +
                "Economista y Profesora de economía de " +
                "la Universidad de Columbia. Experta en " +
                "Cambio climático. Participó en el " +
                "TEDxUTN 2013, entre otros.");
        sqLiteDatabase.insert("Speakers", null, speaker9);


        // sqLiteDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
