package overhead.caeii2017;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SqliteConector extends SQLiteOpenHelper {

    private String sqlCreate;

    public SqliteConector(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqlCreate = "CREATE TABLE Speakers (name TEXT, SpeakerText TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertSpeakers(sqLiteDatabase);
        sqlCreate = "CREATE TABLE TechnicalVisits(name TEXT, duration INTEGER, address TEXT, day INTEGER, month INTEGER, year INTEGER, place TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertTechnicalVisits(sqLiteDatabase);
        sqlCreate = "CREATE TABLE Turns(name Text, hour INTEGER, minute INTEGER, number TEXT,id INTEGER)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertTurns(sqLiteDatabase);


        // sqLiteDatabase.close();
    }

    private void insertTurns(SQLiteDatabase sqLiteDatabase) {
        String name = "Bodega Garbin";
        int hour = 2;
        int minute =30;
        int number=1;
        int id=0;


        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id);


        hour =2;
        minute = 29;
        number=2;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id);

        hour = 18;
        minute = 34;
        number=3;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id);

        name="Ketobac";
        hour=19;
        minute=5;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id);

        hour=8;
        minute=30;
        number=2;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id);

        hour=9;
        minute=15;
        number=3;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id);

        hour=10;
        minute=00;
        number=4;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id);

        name="El Secreto";
        hour=15;
        minute=45;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id);


    }

    private void insertSpecificTurn(SQLiteDatabase sqLiteDatabase, String name, int hour, int minute,int number,int id) {
        ContentValues turn = new ContentValues();
        turn.put("name", name);
        turn.put("hour", hour);
        turn.put("minute", minute);
        turn.put("number",number);
        turn.put("id", id);
        sqLiteDatabase.insert("Turns", null, turn);

    }

    private void insertTechnicalVisits(SQLiteDatabase sqLiteDatabase) {
        String name = "Bodega Garbin";
        int duration = 60;
        String address = "Castelli 1331";
        int day = 14;
        int month = 3;
        int year = 2017;
        String place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "Ketobac";
        duration = 40;
        address = "Av San Martin 175 - Av. Hip. Irigoyen y Pelegrini";
        day = 13;
        month = 3;
        year = 2017;
        place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "El Secreto";
        duration = 90;
        address = "Ruta 144, km 674.5";
        day = 13;
        month = 3;
        year = 2017;
        place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);


    }

    private void insertSpecificVisit(SQLiteDatabase sqLiteDatabase, String name, int duration, String address, int day, int month, int year, String place) {
        ContentValues visit = new ContentValues();
        visit.put("name", name);
        visit.put("duration", duration);
        visit.put("address", address);
        visit.put("day", day);
        visit.put("month", month);
        visit.put("year", year);
        visit.put("place", place);
        sqLiteDatabase.insert("TechnicalVisits", null, visit);
    }

    private void insertSpeakers(SQLiteDatabase sqLiteDatabase) {

        String name = "Marcela Riccillo";
        String text = "Doctora en Ciencias de la Computación de la Universidad de Buenos " +
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
                "varios años de estudio de Coreano, Japonés,Chino, Inglés, Alemán y Latín.";

        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Lino Barañao";
        text = "Recibido como Licenciado en Ciencias Quimicas y luego Doctor en " +
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
                "Productiva de la Nación.";

        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Debora Giorgi";
        text = "Es Licenciada en Economía de la Universidad " +
                "Católica Argentina con Diploma de Honor. " +
                "Ex Secretaria de industria, comercio, minería " +
                "Fue directora del Centro de Estudios para las " +
                "Negociaciones Internacionales " +
                "(CENI) " +
                "A partir de 2005 fue Ministra de " +
                "Asuntos Agrarios y Producción " +
                "Ex Ministra de Industria";

        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Gino Tubaro";
        text = "Es inventor, fundador de Atomic Lab, donde se " +
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
                "History Channel.";
        insertSpecificSpeaker(sqLiteDatabase, name, text);


        name = "Andy Freire";
        text = "Andrés \"Andy\" Freire es el Ministro de Modernización, Innovación y " +
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
                "Mundial en Davos, Suiza.";
        insertSpecificSpeaker(sqLiteDatabase, name, text);


        name = "Miguel Galuccio";
        text = "Ingeniero en Petroleo del Instituto Tecnológico de Buenos Aires (ITBA). Ex " +
                "CEO de YPF. " +
                "Es un experto en la localización y perforación para hallar petróleo, lo que " +
                "se conoce como \"reservorista\". A pesar de su corta edad, tiene una " +
                "experiencia confiable en todos los continentes y un alto grado de " +
                "especialización en la profesión.";
        insertSpecificSpeaker(sqLiteDatabase, name, text);


        name = "Cecilia Smoglie";
        text = "Licenciada en Física (Instituto Balseiro, abanderada, 1977), Postgrado " +
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
                "universidad - empresa. Tiene 22 trabajos escritos para la Industria, 14 publicaciones y 3 patentes.";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Alejandro Ceccatto";
        text = "Realizó sus estudios en la Universidad Nacional de Rosario como " +
                "Licenciado en Física recibiendose en 1979. En 1985 culmina con " +
                "su doctorado en Fisica en la Universidad Nacional de La Plata, " +
                "dando lugar luego a dos Posdoctorados en la Universidad de " +
                "Colonia (Alemania) y la Universidad de Standford (USA). " +
                "En la actualidad participa como Investigador principal en el CONICET " +
                "ademas de ser miembro asociado del Centro Internacional de " +
                "Fisica Teorica (Triesta, Italia). Además desde 2008 es el " +
                "Secretario de Articulacíón Cientifico Tecnologico del Ministerio de " +
                "Ciencia, Tecnología e Innovación Productiva.";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Graciela Chichilnisky";
        text = "Doctora en Matemáticas recibida en la " +
                "Universidad de California. " +
                "Economista y Profesora de economía de " +
                "la Universidad de Columbia. Experta en " +
                "Cambio climático. Participó en el " +
                "TEDxUTN 2013, entre otros.";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

    }

    private void insertSpecificSpeaker(SQLiteDatabase sqLiteDatabase, String name, String text) {
        ContentValues speaker1 = new ContentValues();
        speaker1.put("name", name);
        speaker1.put("SpeakerText", text);
        sqLiteDatabase.insert("Speakers", null, speaker1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlDestroy = "DROP TABLE Speakers";
        sqLiteDatabase.execSQL(sqlDestroy);
        sqlCreate = "CREATE TABLE Speakers (name TEXT, SpeakerText TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertSpeakers(sqLiteDatabase);
         sqlDestroy = "DROP TABLE TechnicalVisits";
        sqLiteDatabase.execSQL(sqlDestroy);

        sqlCreate = "CREATE TABLE TechnicalVisits(name TEXT, duration INTEGER, address TEXT, day INTEGER, month INTEGER, year INTEGER, place TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertTechnicalVisits(sqLiteDatabase);

        sqlDestroy = "DROP TABLE Turns";
        sqLiteDatabase.execSQL(sqlDestroy);

        sqlCreate = "CREATE TABLE Turns(name Text, hour INTEGER, minute INTEGER, number TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertTurns(sqLiteDatabase);
    }
}
