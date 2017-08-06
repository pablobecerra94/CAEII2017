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
        sqlCreate = "DROP TABLE IF EXISTS Speakers";
        sqlCreate = "DROP TABLE IF EXISTS TechnicalVisits";
        sqlCreate = "DROP TABLE IF EXISTS Turns";

        sqlCreate = "CREATE TABLE Speakers (name TEXT, SpeakerText TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertSpeakers(sqLiteDatabase);
        sqlCreate = "CREATE TABLE TechnicalVisits(name TEXT, duration INTEGER, address TEXT, day INTEGER, month INTEGER, year INTEGER, place TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertTechnicalVisits(sqLiteDatabase);
        sqlCreate = "CREATE TABLE Turns(name Text, hour INTEGER, minute INTEGER, number TEXT,id INTEGER,alarm TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertTurns(sqLiteDatabase);


        // sqLiteDatabase.close();
    }

    private void insertTurns(SQLiteDatabase sqLiteDatabase) {
        String name = "Bodega Garbin";
        int hour = 16;
        int minute =55;
        int number=1;
        int id=0;
        String alarm="False";


        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);


        hour =16;
        minute = 58;
        number=2;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        hour = 18;
        minute = 34;
        number=3;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        name="Ketobac";
        hour=19;
        minute=5;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        hour=8;
        minute=30;
        number=2;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        hour=9;
        minute=15;
        number=3;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        hour=10;
        minute=00;
        number=4;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        name="El Secreto";
        hour=15;
        minute=45;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);


    }

    private void insertSpecificTurn(SQLiteDatabase sqLiteDatabase, String name, int hour, int minute,int number,int id, String alarm) {
        ContentValues turn = new ContentValues();
        turn.put("name", name);
        turn.put("hour", hour);
        turn.put("minute", minute);
        turn.put("number",number);
        turn.put("id", id);
        turn.put("alarm",alarm);
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

        // ADN Industrial
        String name = "Martín Urquizo";
        String text = "Actualmente es Gerente de Negocios Online de " +
                "OCA, compañía líder en servicios logísticos para ecommerce en Argentina. También es Director de la " +
                "Cámara Argentina de Comercio Electrónico " +
                "(Comisión de Logística). " +
                "Martin Urquizo es Licenciado en Marketing, Máster en " +
                "Administración de Empresas y cuenta con un post grado " +
                "en eBusiness Management. Tiene experiencia en la implementación " +
                "de canales de venta online, operaciones y el desarrollo de negocios " +
                "web para diferentes empresas líderes del sector. ";

        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Marcos Aquino";
        text = "Ingeniero Industrial (ITBA). Master Ingeniería de la " +
                "Innovación (U. de Bologna). Master Gestión de " +
                "Negocios (Universidad San Andrés). Wine Executive " +
                "Program (UC Davis, California). " +
                "Gerente de logística de Grupo Peñaflor. Se " +
                "desempeñó como Supply Planner Manager en Danone " +
                "(Alimentos) y como Supply Chain Perf. Manager Dairy Latam Danone " +
                "(Alimentos). Trabajo durante 10 años en Quilmes ocupando diversos " +
                "puestos de diferentes niveles jerárquicos ";

        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Andrés Villamor";
        text = "Ingeniero industrial (UBA). Gerente de operaciones de " +
                "Tenaris. Sus principales Responsabilidades son: " +
                "Planificar, organizar, dirigir y ejecutar operaciones " +
                "óptimas en el día a día, enfocarse en la excelencia " +
                "industrial en seguridad, calidad y cumplimiento para " +
                "superar las expectativas de nuestros clientes. Desarrollar " +
                "con centros de I + D nuevos productos de acuerdo a las " +
                "expectativas nuevas y futuras de los clientes. Comprender las necesidades y " +
                "requisitos de los clientes para desarrollar procesos efectivos de control de " +
                "calidad. Apoyar y resolver las reclamaciones de los clientes. Implementar " +
                "estrategias alineadas con las iniciativas estratégicas y proporcionar un " +
                "sentido claro de dirección y enfoque, asegurando que el negocio funcione " +
                "dentro de la declaración de la empresa. Desarrollar e implementar nuevos " +
                "sistemas y procesos que rastreen y optimicen la productividad y estándares, " +
                "métricas y metas de desempeño para asegurar un retorno efectivo de los " +
                "activos. Asegurar que los objetivos industriales, financieros y otros " +
                "acordados se cumplan en todos los departamentos. Abordar los problemas " +
                "o quejas de los empleados y administrar los convenios colectivos. Mantener " +
                "a los empleados motivados y organizando el entrenamiento apropiado. " +
                "Diseñar e implementar planes de desarrollo para WC y BC ";

        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Augusto Cicaré";
        text = "A los 11 años, cursando 5º grado, construye su primer " +
                "motor de cuatro tiempos con el cual hace funcionar un " +
                "lavarropas. Siendo apenas un joven de 18 años de edad, " +
                "desarrolla y fabrica totalmente un motor diesel de dos " +
                "tiempos. A los 21 años de edad Augusto concreta su " +
                "ambición de niño de fabricar y volar su primer " +
                "helicóptero, el CICARE CH-1. En 1970 el Ministerio de " +
                "Educación y Cultura de la Nación lo nombra Maestro Técnico. " +
                "A pedido de Juan Manuel Fangio diseña y construye un nuevo motor de " +
                "cuatro cilindros en V de cuatro tiempos para instalar en automóviles DKW. " +
                "En el año 1975 transforma los motores nafteros de seis cilindros de Ford y " +
                "Chevrolet a diesel, mediante el agregado de una nueva tapa de cilindros. " +
                "El 6 de Octubre de 1993 se forma la Empresa Cicaré Helicópteros S.A.. " +
                "Augusto Cicaré es designado Director y Responsable Técnico de la misma. " +
                "En el año 1994 desarrolla para Cicaré Helicópteros S.A. el " +
                "Simulador/Entrenador de Vuelo para Helicópteros CICARE SVH-3, que " +
                "revolucionó el sistema de enseñanza en el mundo entero por sus " +
                "características únicas. Este Simulador obtuvo patentes en Argentina y " +
                "Estados Unidos. " +
                "El 10 de Agosto de 1996 recibe la distinción de Amigo de la Fuerza Aérea " +
                "Argentina según resolución 476/88. El 20 de Septiembre de 1996 el Consejo " +
                "Profesional de la Ingeniería Aeronáutica y Espacial le otorga a Cicaré, por ser " +
                "referencia mundial en el campo de la Ingeniería Aeronáutica, la Matrícula " +
                "Honoraria de Ingeniero Aeronáutico y Espacial. " +
                "En noviembre de 1998 participa del concurso Ladislao José Biro, auspiciado " +
                "por el Instituto Nacional de la Propiedad Industrial (INPI) y la Asociación " +
                "Argentina de Inventores. Se le otorga el primer premio en la categoría " +
                "Mecánica y es seleccionado como el mejor invento nacional del año, con el" +
                "reconocimiento de la Federación Internacional de Inventores ( IFIA ) y la " +
                "Organización Mundial de la Propiedad Intelectual (OMPI). Por tal motivo " +
                "representa a la República Argentina en la Exposición Internacional de " +
                "inventos en Ginebra, Suiza, obteniendo Medalla de Oro en la Categoría P " +
                "(Aeronáutica, náutica, vehículos y accesorios). " +
                "El 12 de mayo de 1999 el Senado y la Honorable Cámara de Diputados " +
                "nombra por unanimidad como Ciudadano Ilustre de la Provincia de Buenos " +
                "Aires a Augusto Ulderico Cicaré. A mediados de 2002 realiza las primeras pruebas de un novedoso sistema " +
                "que permite alimentar en forma dual (Gasoil y GNC) motores de ciclo Diesel. " +
                "El 19 de Enero de 2004 el Instituto del Gas Argentino (IGA) emite el " +
                "Certificado de Homologación del Sistema Diesel-Gas Cicaré. " +
                "El 20 Diciembre de 2004 es galardonado por segunda vez con el Premio " +
                "“Juan Manuel Fangio” a la innovación tecnológica en la industria automotriz " +
                "y autopartista, instituido por el Banco de la Provincia de Buenos Aires. " +
                "El 1º de Setiembre de 2005 el Consejo Académico de la Facultad de " +
                "Ingeniería de la Universidad Nacional del Centro de la Provincia de Buenos " +
                "Aires lo distingue como Empresario Innovador 2005, por su contribución al " +
                "medio ambiente en general, y al sector del transporte en particular, " +
                "mediante el desarrollo del Sistema Dual Diesel-Gas Cicaré. El 2 de Setiembre " +
                "de 2005 recibe el 2º Premio del concurso INNOVAR 2005 en el marco de las " +
                "Terceras Jornadas Nacionales de Diseño, por su innovación tecnológica " +
                "denominada Sistema Dual Diesel-Gas Cicaré. El 27 de Mayo de 2008 recibe " +
                "la Orden al Mérito Newberiano y es incorporado como Miembro de Honor al " +
                "Instituto Nacional Newberiano. ";

        insertSpecificSpeaker(sqLiteDatabase, name, text);


        name = "Eduardo Jorge Oreste";
        text = "Ingeniero Mecánico (UNLP). Especialización en " +
                "combustibles (UBA). BMA (University of Texas at Austin). " +
                "Actualmente se desempeña como Gerente General en " +
                "Cicaré S.A. " +
                "Nos hablará sobre el desafío de realizar el salto " +
                "productivo de la empresa Cicaré, única productora de " +
                "helicópteros en Sudamérica, para que además de ser un "  +
                "orgullo argentino, triplicara su producción y adaptaran su modo de producir " +
                "para cumplir la demanda creciente. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);


        name = "Alejandro Leiras";
        text = "Director de Estudios e Investigacón de ARLOG " +
                "(Asociación Argentina de Logística Empresaria). " +
                "Docente Universitario en ITBA. Licenciado en " +
                "comercialización, canales de distribución y logística " +
                "(UAI). Posgrado en Redes Logísticas (ITBA). ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);


        name = "Mario Paredes";
        text = "Trabaja actualmente y desde hace 13 años, en el " +
                "Instituto Nacional de Tecnología Industrial y se " +
                "desempeña como Asesor en Tecnologías de Gestión " +
                "(ATG). " +
                "Experto en materiales de caucho, rubro en el que se " +
                "destacó sucesivamente durante 15 años para la industria nacional y privada: operador, formulador, programador de la " +
                "producción, supervisor y jefe de planta. " +
                "Técnico Mecánico y Técnico Superior en Tecnología Industrial, " +
                "actualmente finalizando la carrera de Ingeniería Industrial en la UNGS. " +
                "Experto en manejo de equipos de trabajo, liderazgo y motivación del " +
                "personal. Experto y docente en Mejora de la Productividad para " +
                "Pymes. " +
                "Asesoró empresas y organismos como: YPF, Fabricaciones Militares, " +
                "Ministerio de Producción, Ministerio de Seguridad, Ministerio de " +
                "Desarrollo, cooperativas de trabajo y PyMEs de diversos rubros " +
                "industriales. " +
                "Es Asesor en los Programas Experto PyME y Crédito Fiscal, para el " +
                "Ministerio de Producción. " +
                "Disertante para el INTI, en temáticas relacionadas a las Herramientas " +
                "de Gestión Productiva (Lean Manufacturing, Toyota Production " +
                "Sistem y otras).";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Diego Prado";
        text = "Diego Prado es abogado recibido en la Universidad " +
                "de Buenos Aires. Ingresó a Toyota Argentina en " +
                "noviembre de 2006 como Gerente General de " +
                "Recursos Humanos. En enero de 2017 asumió el " +
                "cargo de Director de Asuntos Corporativos de la " +
                "compañía. Tiene 53 años, está casado y tiene 3 hijos. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        //Mision 2050

        name = "Andrés Sartarelli";
        text = "Licenciado en Ciencias Físicas (UBA). Doctor en " +
                "Ciencias Físicas (UBA). Especialización en " +
                "Energía solar térmica (INTI) y en aprovechamiento " +
                "de la energía solar (UNLU). Docente universitario en " +
                "UNGS. Investigador en las temáticas: “Eficiencia " +
                "energética y energías renovables apropiadas para la " +
                "agricultura familiar y el desarrollo rural” y en " +
                "“Refrigeración solar apropiable”. Ha publicado numerosos artículos en " +
                "revistas nacionales e internacionales. Ha participado como orador en " +
                "diversos eventos relacionados con las energías renovables. Ha " +
                "recibido el premio Fundación Ford Motor Company de conservación y " +
                "Medio Ambiente por su proyecto “Energía solar aplicada a la " +
                "producción de frío”. ";

        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Mónica Miralles";
        text = "Doctora en Ciencias Físicas (FCEyN- UBA), Licenciada " +
                "en Ciencias Físicas (FCEyN- UBA), Profesora de"  +
                "Ciencias Físicas (FFyL-UBA). Profesora Adjunta" +
                "Regular de Física para Diseño Industrial (FADU-UBA), " +
                "y JTP Regular en FI-UBA, Profesora Titular de " +
                "Mecánica de los Fluidos en UCA; Profesora Titular de " +
                "Biomateriales (ITBA).Directora del Laboratorio de " +
                "Biomecánica e Ingeniería para la Salud (LaBIS-UCA). Como " +
                "investigadora, cuenta con numerosas publicaciones, presentaciones a " +
                "congresos, dirección de proyectos, diversos comités de evaluación, " +
                "formación de recursos humanos, entre otras actividades académicas " +
                "relacionadas. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Laura Toledo";
        text = "Ingeniera Industrial, egresada de la Universidad " +
                "Tecnológica Nacional, Facultad Regional Haedo, y " +
                "especializada en Gestión de la Vinculación y la " +
                "Transferencia Científico-Tecnológica por la " +
                "Universidad Nacional del Litoral. Desde 2012 es " +
                "coordinadora del área de Promoción e Innovación de la " +
                "Fundación Argentina de Nanotecnología. Allí es responsable de la evaluación de proyectos emprendedores, su financiamiento e " +
                "incubación. Previamente, se desempeñó en tareas de producción, " +
                "marketing, logística y comercio internacional en PyMEs y " +
                "multinacionales. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Cecilia Smoglie";
        text = "Licenciada en Física, Instituto Balseiro, Argentina. " +
                "Postgrado en Ingeniería Nuclear, University of " +
                "London, Inglaterra. Doctorado en Ingeniería " +
                "Mecánica, Karlsruhe Institut für Technologie (KIT), " +
                "Alemania. Trabajo como investigadora en el Centro " +
                "Atómico de Bariloche. Fue investigadora invitada en " +
                "el Centro Atómico de Karlsruhe, Alemania. Trabajó como " +
                "ingeniera de desarrollo, Asea Brown Boveri, Suiza. Actualmente se " +
                "desempeña en el ITBA como Prof. de Postgrado en Termodinámica, " +
                "Calor, Energía. Es Directora de la Maestría ITBA-KIT en Energía y " +
                "Ambiente y Coordinadora del Área de Energía ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Martin Vila";
        text = "Desarrollador DevOps, Python developer. Insignia " +
                "Microsoft de Seguridad para Profesionales de IT. " +
                "Experto universitario en Ethical Hacking, Vocero " +
                "junior de Argentina Cibersegura, realice varios " +
                "cursos en la Microsoft Virtual Academy relacionados " +
                "a la virtualización y la gestión en \"la nube\". " +
                "Fundador de Synapdica IT, Emprendimiento que " +
                "desarrolla tecnología con plataforma Open Source para sensorizado y " +
                "automatización. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Joan Cwaik";
        text = "Joan Cwaik es un innovador tecnológico, autor, " +
                "docente, productor y conferencista internacional. " +
                "Joan es una de las voces más vigentes en " +
                "tecnologías disruptivas y paradigmas digitales de " +
                "América Latina. Licenciado en Gestión de Medios y " +
                "Entretenimiento (UADE). Posgrado en Convergencia " +
                "Multimedial (UBA). Gerente de Marketing para " +
                "Latinoamérica en Maytronics. Responsable del Centro de Divulgación " +
                "Tecnológica de la Facultad de Ingeniería y Ciencias Exactas de la " +
                "Fundación UADE. Columnista de tecnología en La Nación, Infobae, " +
                "C5N, FM UNO 103.1 y FM Millenium 106.7. Nominado por la Revista Apertura y La Red Innova como uno de los emprendedores " +
                "tecnológicos más influyentes de la Argentina en 2015. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Victor Manuel Fontan";
        text = "Es Ingeniero Químico graduado de la Universidad " +
                "Tecnológica Nacional – Facultad Regional Buenos " +
                "Aires, con Postgrado en Administración de " +
                "Empresas. Posee una extensa trayectoria " +
                "gerenciando calidad, investigación y desarrollo " +
                "tecnológico en empresas nacionales de distinta " +
                "envergadura. Se desempeñó como Jefe de Calidad, " +
                "Medio Ambiente y Seguridad e Higiene de la " +
                "empresa GALVASA S.A. y posteriormente ejerció la Gerencia de " +
                "Planta. Es Auditor de Sistemas de Gestión de la Calidad ISO 9001 del " +
                "Instituto Argentino para la Calidad habiendo implementado ISO9000 " +
                "en empresas con más de 50 años de trayectoria. Llevó a cabo el " +
                "Management de Proyectos como el diseño y construcción de una " +
                "Planta de pre-procesado de caucho, diseño de aislación de hornos de " +
                "galvanizado y diseño y construcción de planta de tratamiento de " +
                "efluentes. Project Manager de la construcción del laboratorio de " +
                "simulación de procesos del Departamento de Ingeniería Química de " +
                "la Universidad Tecnológica Nacional, Facultad Regional Buenos Aires. " +
                "Miembro Consultor de la Asociación Argentina de Galvanizado por " +
                "Inmersión en Caliente (AAGIC) cuya misión es la de difundir y " +
                "promover las consecuencias de la corrosión y las bondades del " +
                "galvanizado por inmersión en caliente. A través de AAGIC participó de " +
                "la visita y el asesoramiento de numerosas empresas dedicadas al " +
                "galvanizado por inmersión caliente en Chile, Argentina, Brasil y España. Se capacitó en Gestión de industrias de Galvanizado en " +
                "Santiago de Chile, Chile. Participó en el Congreso Internacional de la " +
                "Industria del Galvanizado INTERGALVA 2009 Madrid-Barcelona, " +
                "España. Participó en el Congreso Latinoamericano de la Industria del " +
                "Galvanizado Latingalva São Paulo 2007 y en foros y charlas " +
                "específicas de la industria en el ámbito latinoamericano. Ha disertado " +
                "en las Jornada Argentina de Galvanizado “GalvArgentina” en sus " +
                "ediciones 2013 y 2014, evento internacional organizado por el Instituto " +
                "Nacional de Tecnología Industrial (INTI), junto a disertantes de la " +
                "Comunidad Europea. Es miembro experto del IRAM para ISO en la " +
                "elaboración y discusión de normas técnicas, actualmente en el " +
                "proyecto de la norma argentina de Galvanizado por Inmersión en " +
                "Caliente. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Norma Cadoppi";
        text = "La Dra. Norma Cadoppi es Médica de la Universidad " +
                "de Buenos Aires, y desde 2005 es Presidente de la " +
                "Fundación Foro Estratégico para el Desarrollo " +
                "Nacional, que nuclea a más de 300 especialistas de " +
                "distintas áreas del conocimiento y reconocida " +
                "idoneidad profesional, con la Misión de pensar nuevas " +
                "oportunidades de desarrollo socio-productivo " +
                "sustentable para la Argentina. " +
                "Es Magister en Energías Renovables y Cambio Climático del Instituto " +
                "Europeo del Empleo (I.E.E.), dependiente de la Unión Europea. Hizo su " +
                "especialidad médica en Oncología Clínica y Quimioterapia en el " +
                "Hospital de la Santa Creu y Sant Pau de Barcelona, España, y en el " +
                "Instituto Nazionale per lo Studio e la Cura dei Tumoride Milán, Italia. " +
                "Fue Coordinadora General de Política Ambiental y Desarrollo " +
                "Sustentable de la Jefatura de Gabinete de Ministros de la Nación; " +
                "Representante del Gobierno Nacional en la 4º Cumbre de Cambio " +
                "Climático en Bonn, Alemania; Chair del Banco Mundial por la " +
                "República Argentina ante el Steering Committee en la “Iniciativa Aire " +
                "Limpio para las ciudades de América Latina”. Washington 1998-2003; " +
                "Coordinadora General del Programa Aire Limpio 1998-2000, GCABA; " +
                "Representante del Gobierno Nacional en la 1ª Reunión del Comité de " +
                "Países Huéspedes (HCC) para la Mitigación de Gases Efecto " +
                "Invernadero; Coordinadora del Centro de Estudios de Salud y Medio " +
                "Ambiente de la Academia Nacional de Medicina. Dr. Andino Pavlovsky " +
                "y Dr. Horacio Rubio. " +
                "Recibió en 1999 el Premio otorgado por el Congreso de la Nación " +
                "Argentina a la Mujer Destacada en el ámbito nacional, por su " +
                "desempeño en las áreas de Medio Ambiente y Salud. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Catalina Lonac";
        text = "Abogada (Universidad Nacional de Tucumán). " +
                "Procuradora (Universidad Nacional de Tucumán). " +
                "Postgrado en negociación (Universidad de " +
                "Berkeley). Presidente de la Fundación para el " +
                "Desarrollo de la Universidad de San Pablo Tucumán. " +
                "Vicepresidente de Cía. Azucarera Los Balcanes S.A., " +
                "ingenios y destilerías La Florida y Cruz Alta. " +
                "Vicepresidente de Cía. Energética La Florida. Socia gerente " +
                "de Covemat S.R.L. – petrolera de segundo grado. Miembro del " +
                "Honorable Directorio del IDEP, Instituto de Desarrollo Productivo de " +
                "Tucumán. Representante de la Industria Azucarera. Miembro del " +
                "Honorable Directorio de la Estación Experimental Agroindustrial " +
                "Obispo Colombres, ente autárquico de la provincia. Representante de " +
                "la Industria Azucarera. Cónsul Honoraria de la República de Croacia " +
                "para las siete provincias del Norte Argentino. Miembro de Número de " +
                "la Academia Internacional de Derecho Comparado. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Hernán Charreau";
        text = "Licenciado en Ciencias Químicas con orientación en " +
                "Análisis Biológicos – Facultad de Ciencias Exactas " +
                "UBA. " +
                "Magister en Organización e Innovación - Université " +
                "Paris DAUPHINE " +
                "Magister en Prospectiva y Estrategia de las " +
                "Organizaciones y Magister en Prospectiva y Evaluación de la Investigación y la Tecnología - Conservatoire des " +
                "Arts et Métiers, París " +
                "Desde el 2008 está a cargo de la unidad de Inteligencia Tecnológica " +
                "en Clarke, Modet & Co Argentina. " +
                "Con anterioridad a la incorporación a Clarke, Modet & Cº fue consultor " +
                "de la Agencia Nacional de Promoción Científica y Tecnológica " +
                "(ANPCyT) y del Ministerio de Ciencia, Tecnología e Innovación " +
                "Productiva (MinCyT). ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Paulo Strina";
        text = "Ganador de Mi Concurso";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        // Cartas

        name = "Jorge Camblong";
        text = "Profesional de las ramas del área Electrónica y de la " +
                "Organización Industrial. Socio fundador de TCC con 20 " +
                "años de existencia en el mercado en el rubro " +
                "teleinformática. Docente con más de 30 años de " +
                "experiencia en Secundarios, Terciarios, Universidades e " +
                "Institutos propios. Consultor Industrial. Con tesis en " +
                "Maestría en Educación presentada a punto de defender y en " +
                "proceso de desarrollo de tesis doctoral en Ingeniería Industrial. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Gastón Morales";
        text = "Formación y consultoría en Creatividad e Innovación / " +
                "Estilos de Pensamiento BTSA (Test de Dominancia " +
                "Cerebral) / Desarrollo de Carrera / Coaching / Diseño de " +
                "Marca Personal / Marketing focalizado en Cliente / " +
                "Experiencia de Cliente (Marketing Experience) / " +
                "Psicología de Consumidor. " +
                "Licenciado en sistemas y computación (UCA). Docente universitario en UCA " +
                "y en Escuela Argentina de negocios. Coordinador del programa " +
                "“neurociencia para lideres” en Universidad de San Andrés.";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Daniel Rodríguez";
        text = "Ingeniero Químico (UBA). Master en Administración " +
                "de Empresas (Universidad del CEMA). South Latin " +
                "Division Customers’ Service Director de COCACOLA DE ARGENTINA. Responsable por liderar el " +
                "desarrollo de estrategias y proyectos a nivel Regional " +
                "en el nivel de servicio a clientes clave (Carrefour, " +
                "Walmart, Cencosud, etc). Liderazgo en la implementación de " +
                "procesos de mejora y eficiencia a lo largo de toda la cadena de valor " +
                "orientados a incrementar la disponibilidad de productos en el " +
                "mercado. Introducción de nuevos modelos operativos, herramientas y " +
                "metodologías alineadas con la búsqueda de excelencia en el servicio " +
                "a clientes. Desarrollo de capacidades e integración de equipos " +
                "multifuncionales alineados con las necesidades de servicio a clientes. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Lucas Damián Herrero";
        text = "Maestría en Gestión de " +
                "Proyectos (Universidad Politécnica de Cataluña), y " +
                "Especialista en Ingeniería Ambiental (UTN) y Diplomatura " +
                "en Tratamiento de agua (ONU). Posee experiencia en " +
                "gerenciamiento de proyectos de desarrollo energético y " +
                "desarrollo. Especialista de Proyectos de energía, " +
                "remediación ambiental y saneamiento. Experiencia en " +
                "desarrollo e implementación de soluciones de " +
                "abastecimiento y tratamiento de aguas para distintas " +
                "ONG´s y Fundaciones. Docente UTN y UP. Director del " +
                "proyecto de investigación y desarrollo “Relevamiento integral de empresas " +
                "pymes con desarrollo de alternativas para mejorar su eficiencia energética” " +
                "en la Universidad Tecnológica Nacional. Actualmente es Socio Gerente de " +
                "Vadeka Servicios SRL, consultora Energética y Ambiental";

        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Brian Vallejo";
        text =  "Brian Daniel Vallejo: Estudiante de ingeniería industrial, " +
                "adeudando solo tesis. Técnico en industria plástica para " +
                "mejoras para los procesos productivos. Es docente " +
                "auxiliar en UTN Haedo de la cátedra Estudio del trabajo. " +
                "Ha coordinado actividades de voluntariado universitario " +
                "en su facultad y también forma parte de un grupo de " +
                "investigación de eficiencia energética ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Enrique Alberto Pesl";
        text = "Ingeniero Industrial egresado de la Universidad " +
                "Nacional del Sur (Orientación Organización de " +
                "Empresas). Especializado en Protección Ambiental. " +
                "Se desempeñó como docente en diversas áreas. " +
                "Trabajó en peritaje para Estudios Jurídicos y como " +
                "Perito Técnico de oficio en tribunales de la provincia " +
                "de Buenos Aires y en el Tribunal del Poder Judicial de la " +
                "Nación. También se desempeñó como consultor en áreas de gestión " +
                "ambiental y para la Subsecretaría de Minería de la Nación. " +
                "Título: “La experiencia personal es " +
                "intransferible” " +
                "Los Planes de Estudios tratan de brindar al profesional una formación " +
                "básica, de modo tal que intentan prepararlos para que pueda hacer " +
                "frente a los problemas y desafíos que se le presentan en la vida " +
                "cotidiana de la empresa. " +
                "Los avances de la tecnología han hecho que los temas de ingeniería " +
                "que se resolvían aplicando recetas de libros, ahora hay que recurrir al " +
                "criterio y creatividad del profesional, buscando la solución del " +
                "problema y si además es la mejor solución, mejor aún. Por lo cual la " +
                "especialización resulta muy importante. " +
                "Resulta difícil anticiparles a ustedes, situaciones en las cuales todavía " +
                "no se encuentran involucrados, pero el objetivo de esta exposición es " +
                "simplemente narrar parte de las actividades profesionales en las " +
                "cuales desarrollé mi carrera profesional.";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Alejandro Mangioni";
        text = "Ingeniero en sistemas de información (UTN). " +
                "Especialización en gestión de proyectos (UTN) " +
                "Especialización en liderazgo (UTN). " +
                "Coach ontológico (Técnico en liderazgo y diseño " +
                "ontológico). " +
                "Docente universitario en UTN. " +
                "Arquitecto Sr de sistemas en Banco Galicia. ";
        insertSpecificSpeaker(sqLiteDatabase, name, text);

        name = "Carlos Balseiro";
        text = "Licenciado en Física Instituto Balseiro 1973. Doctor " +
                "en Física Instituto Balseiro 1978. Estadía posdoctoral " +
                "beca externa CONICET en la Universidad de " +
                "California, Berkeley 1978 y 1979. " +
                "Vicedirector del Instituto Balseiro 1984-1988 " +
                "Subgerente Instito de Nanociencia y NanotecnologíaCNEA desde su creación hasta 2013 " +
                "Coordindor Funta de Calificaciones CONICET 2012 (como miembro " +
                "2010 y 2011) " +
                "Director Instituto Balseiro 2016 " +
                "Investigador CNEA, Investigador Superior CONICET, Profesor Titular " +
                "IB – UNCuyo. " +
                "Proyectos de Investigación recientes: Responsable PICT Bicentenario " +
                ", ANPCYT (2010). Se trata de un proyecto teórico-experimental en el " +
                "que participan investigadores de distintos grupos del CAB " +
                "Responsable administrativo PAE 2006 CINN. Se trata de un proyecto " +
                "interinstitucional CNEA- UBA-CONICET: Grupo responsable Dres " +
                "Calvo, Salvarezza, Balseiro, Bragas, Fainstein Soler-Illia, Requejo. " +
                "Responsable frente a CNEA de Proyecto Eulasur entre países de la UE " +
                "y Mercosur. " +
                "En el pasado responsable proyectos: Antorchas (600.000usd). PME " +
                "2003 para compra de equipamiento ANPCYT (600.000 usd) y varios " +
                "PICT de ANPCYT. " +
                "Producción en Investigación: Más de 170 trabajos publicados en " +
                "revistas internacionales incluyendo un par de artículos de difusión. " +
                "Entre estos cabe destacar un artículo publicado en Science, 20 en " +
                "Phys. Rev. Lett y 94 en Phys Rev B. " +
                "Participación como expositor invitado en más de 25 conferencias " +
                "internacionales. ";
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
