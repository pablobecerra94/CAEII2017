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
        sqLiteDatabase.execSQL(sqlCreate);
        sqlCreate = "DROP TABLE IF EXISTS TechnicalVisits";
        sqLiteDatabase.execSQL(sqlCreate);
        sqlCreate = "DROP TABLE IF EXISTS Turns";
        sqLiteDatabase.execSQL(sqlCreate);
        sqlCreate = "DROP TABLE IF EXISTS Conferences";
        sqLiteDatabase.execSQL(sqlCreate);

        sqlCreate = "CREATE TABLE Speakers (name TEXT, SpeakerText TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertSpeakers(sqLiteDatabase);
        sqlCreate = "CREATE TABLE TechnicalVisits(name TEXT, duration INTEGER, address TEXT, day INTEGER, month INTEGER, year INTEGER, place TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertTechnicalVisits(sqLiteDatabase);
        sqlCreate = "CREATE TABLE Turns(name Text, hour INTEGER, minute INTEGER, number TEXT,id INTEGER,alarm TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertTurns(sqLiteDatabase);

        sqlCreate = "CREATE TABLE Conferences(name TEXT, text TEXT, speaker TEXT )";
        sqLiteDatabase.execSQL(sqlCreate);
        insertConferences(sqLiteDatabase);

        sqlCreate = "CREATE TABLE VisitText(name TEXT, text TEXT, web TEXT)";
        sqLiteDatabase.execSQL(sqlCreate);
        insertVisitsText(sqLiteDatabase);

        // sqLiteDatabase.close();
    }



    private void insertConferences(SQLiteDatabase sqLiteDatabase) {

        //Mision 2050
        String name = "Transformando en hielo el calor";
        String text = " En un futuro no muy lejano el cuidado del recurso energético pasara a " +
                "ser una cuestión de importancia fundamental. En la producción de " +
                "frio, tanto sea para la conservación de alimentos como la " +
                "aclimatación de los espacios habitables, el consumo energético " +
                "siempre resulta ser elevado. El propósito de nuestro trabajo como " +
                "investigadores de la Universidad Nacional de General Sarmiento, es el " +
                " desarrollo de sistemas de refrigeración que convierten directamente";
        String speaker="Andrés Sartarelli";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "De la Biomecánica a la Ingeniería del Movimiento";
        text = "¿Cuáles son los campos de la biomecánica actual? ¿Cómo se " +
                 "estudian? La importancia de comprender el complejo equilibrio " +
                 "humano. Su impacto en el área de los Factores Humanos y de la " +
                 "Ergonomía. El movimiento visto a partir del procesamiento de " +
                 "señales. ¿Qué hacemos en el LaBIS-UCA?";
        speaker="Mónica Miralles";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "Nanotecnología. Lo pequeño puede cambiar el mundo.";
        text = "Qué es la nanotecnología. Nano-soluciones industriales. Nuevos " +
                "modelos de negocios. La nanotecnología como desafío para la " +
                "ingeniería industrial.";
        speaker="Laura Toledo";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "Rol del Ingeniero en las economías regionales";
        text = "Generar economías regionales sostenibles requiere cubrir " +
                "necesidades básicas, detectar recursos locales aprovechables, " +
                "convertir al habitante del lugar en protagonista de cambios, facilitar " +
                "nexos en la región, la provincia, el país. El rol del ingeniero abarca " +
                "infraestructura, capacitación técnica, concientización para el cuidado " +
                "del ambiente, proyectos de inversión, desarrollo de productos, " +
                "logística. El desafío es sumar pequeños aportes con gran impacto; la " +
                "huella es el desarrollo integral, progresivo, sostenible.";
        speaker="Cecilia Smoglie";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "Ideas del futuro para ingenieros de hoy";
        text = "Enfocado en el emprendedorismo con desarrollo tecnológico y las " +
                "posibilidades desde el Open Source, para la salud y el medio " +
                "ambiente. Se dará un panorama de las posibilidades que pueden " +
                "tener hoy los jóvenes de desarrollar un negocio rentable con baja " +
                "inversión y buena proyección. " +
                "Por último, con una visión más futura de lo que es la inteligencia " +
                "artificial, se hablará de qué manera Argentina puede entrar a ese tipo " +
                "de desarrollos con ingenieros recién recibidos. " +
                "La charla está enfocada desde una visión y experiencia personal " +
                "dentro del mercado emprendedor y sobre cómo una idea junto a la " +
                "tecnología pueden abrir nuevos horizontes.";
        speaker="Martin Vila";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "La era de la innovación disruptiva";
        text = "Vivimos rodeados de nuevos dispositivos, paradigmas digitales, " +
                "interfaces hombre-máquina y un mundo que converge y se fusiona " +
                "tecnológicamente a ritmos exponenciales. Nos proponemos acercar " +
                "claves y brújulas para analizar estos escenarios: los impactos, riesgos " +
                "y oportunidades que traen a la sociedad. Reflexionaremos acerca de " +
                "tres grandes paraguas tecnológicos: robótica e inteligencia artificial; " +
                "realidad virtual/aumentada; y la impresión 3D, para así llegar a " +
                "conversar acerca de los escenarios disruptivos que seremos testigos " +
                "en los próximos años (telemedicina, computación para vestir, " +
                "extensión radical de la vida, dinero 2.0, movimiento maker, smart " +
                "cities, smart homes, automatización 2.0 etc.)";
        speaker="Joan Cwaik";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "Proyectos de Inversión con Acero Galvanizado por Inmersión en Caliente";
        text = "Esta presentación forma parte de un Programa de Capacitación y " +
                "Actualización Profesional que ofrece la Asociación Argentina de " +
                "Galvanizado por Inmersión en Caliente (AAGIC) a Universidades, " +
                "Institutos Tecnológicos, Centros y Consejos Profesionales, Cámaras " +
                "Empresarias y Entidades Gubernamentales, cumpliendo su misión de " +
                "informar y difundir las consecuencias de la corrosión del acero y la " +
                "necesidad de prevenir este fenómeno natural. La corrosión del acero " +
                "constituye un problema mundial de grandes proporciones que " +
                "requiere ser controlado, por ello es objeto de estudio en " +
                "universidades y centros de investigación de todo el mundo para tratar " +
                "de cuantificar y minimizar los peligros que esta representa. " +
                "Se expone de una manera sencilla la naturaleza de este fenómeno, " +
                "presentando algunos mecanismos de control de la corrosión " +
                "incursionando en detalle en el proceso del galvanizado en caliente. " +
                "En esta presentación se describe el proceso físico químico e industrial " +
                "del galvanizado en caliente en sus diversas etapas y se exponen las " +
                "propiedades y ventajas de este sistema de protección de reconocida " +
                "eficacia. Además se explica la utilización del acero galvanizado en los " +
                "proyectos industriales para la mejora de la eficiencia, la seguridad y la " +
                "sustentabilidad.";
        speaker="Victor Manuel Fontan";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "Transformemos el presente, porque el futuro es hoy";
        text = "Presentación de la Fundación Foro Estratégico para el Desarrollo " +
                "Nacional y de los proyectos que buscan contribuir al desarrollo del " +
                "país a través una innovación basada en la ciencia, la tecnología y la " +
                "industria nacional, a partir de la experiencia que tienen en ciencia einnovación nuestras instituciones, y haciendo foco en la incorporación " +
                "de los jóvenes estudiantes y profesionales que serán los responsables " +
                "de afrontar el desafío de colaborar con el bienestar para la Argentina " +
                "del mañana.";
        speaker="Norma Cadoppi";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "La caña de azúcar en el nuevo escenario energético";
        text = "Argentina hoy mezcla sus naftas con un 12% de etanol , el cual " +
                "proviene de la caña de azúcar y del maíz . El gobierno nacional tiene " +
                "en carpeta llevar ese 12% al 15 % y la idea es llegar al uso de motores " +
                "flex. Esto significa un cambio en la matriz energética de la República " +
                "Argentina, cuyo sistema de energías no renovables colapsara hacia " +
                "2.030. Con la ponencia se pretenderá demostrar cómo el cultivo de " +
                "caña de azúcar podrá cumplir con este objetivo";
        speaker="Catalina Lonac";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "Inteligencia Tecnológica: conocer el camino recorrido para llegar más lejos en la innovación sostenible";
        text = "El rol de las patentes como fuente de información tecnológica. La " +
                "vigilancia como factor clave de las decisiones estratégicas en las " +
                "organizaciones. Desafíos de las tecnologías sustentables.";
        speaker="Hernán Charreau";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        //cartas

        name = "La excepción a la regla de Pareto";
        text = "La disertación, centra su objetivo en aquellas habilidades de liderazgo que " +
                "deberá desarrollar el profesional egresado de la universidad. " +
                "Al llegar el profesional a la empresa, enfrentará un sin número de problemas " +
                "y son justamente aquellos dónde menos hemos sido capacitados. " +
                "Generalmente recibimos un 80% de capacitación que nos sirve para el 20% " +
                "de los problemas cotidianos. Mientras que el 80% de la carga laboral la " +
                "tendremos que llevar adelante con habilidades que debemos desarrollar en " +
                "forma personal. " +
                "Liderazgo, objetivos personales, ganar – ganar, empatía, psicología laboral, " +
                "coaching ontológico, serán algunos de los temas tratados.";
        speaker="Jorge Camblong";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);


        name = "Siempre ganamos el juego que realmente estamos jugando";
        text = "Teniendo en cuenta los tiempos que corren, los roles dentro de las " +
                "Organizaciones actuales, en todas sus dimensiones, se acercan más a " +
                "los de generar nuevas realidades que a los de administrar la realidad " +
                "existente. La posibilidad de generar una “diferencia” está más en " +
                "nuestra capacidad de comprometernos con futuros distintos más que " +
                "sólo con el conocimiento específico de herramientas, técnicas o " +
                "modelos que lleven a sostener o mejorar los resultados que se están " +
                "logrando. " +
                "El compromiso es compartir una serie de disparadores, " +
                "conocimientos y experiencias que nos ayuden a reflexionar sobre " +
                "nuestros objetivos y a entender qué significa ser parte de las " +
                "Organizaciones actuales desde una posición de liderazgo,protagonismo y constante interacción en equipos de trabajo, " +
                "actuando cada día en forma consistente con los objetivos buscados. " +
                "Lo que veremos puede ser aplicado desde el primer día, en una " +
                "Organización grande, mediana o pequeña. Podrá significar cambiar " +
                "muchos, algunos o pocos de los paradigmas con los que hoy vemos el " +
                "mundo. Pero sólo una cosa poseerá una total certeza: la decisión " +
                "sobre el juego que realmente queremos jugar está únicamente en " +
                "cada uno de nosotros.";
        speaker="Daniel Rodríguez";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        //TODO Eficiencia e imaginación para la Salud – Un Exo para Linda tiene dos disertantes, ver como se va a manejar.

        name = "La experiencia personal es intransferible";
        text = "Los Planes de Estudios tratan de brindar al profesional una formación " +
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
        speaker="Enrique Alberto Pesl";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "En búsqueda de tu propósito";
        text = "Te invito a hacer un recorrido por tus principios y talentos, " +
                "permitiendo así encontrar el propósito de tu vida y definir tus " +
                "objetivos.";
        speaker="Alejandro Mangioni";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

        name = "¿Que nos dejó la Física del Siglo XX y cómo impactó en nuestras vidas?";
        text = "El desarrollo de la Mecánica Cuántica durante las primera décadas del " +
                "siglo XX fueron, tal vez, una de las mayores revoluciones en nuestra " +
                "forma de interpretar el universo y cambió definitivamente nuestra " +
                "forma de relacionarse con él. Hoy, en un mundo globalizado e " +
                "hiperconectado, casi todas las tecnologías están basadas en las leyes " +
                "y conceptos de la Mecánica Cuántica. " +
                "¿Cuáles fueron los mayores desafíos que se debieron afrontar a la " +
                "hora de formular esta nueva visión? ¿Cómo las entonces nuevasteorías atentan contra nuestro sentido común? Y finalmente ¿Cómo " +
                "éstas han impactado en el desarrollo tecnológico de la humanidad? " +
                "Pensar y analizar algunas de estas preguntas nos llevarán a " +
                "comprender y valorar el impacto de la investigación, y de la mal " +
                "llamada investigación básica, en el desarrollo tecnológico y cultural " +
                "de nuestra época.";
        speaker="Carlos Balseiro";
        insertSpecificConference(name, text,speaker,sqLiteDatabase);

    }

    private void insertSpecificConference(String name, String text, String speaker,SQLiteDatabase sqLiteDatabase) {
        ContentValues conference = new ContentValues();
        conference.put("name", name);
        conference.put("text", text);
        conference.put("speaker", speaker);
        sqLiteDatabase.insert("Conferences", null, conference);
    }

    private void insertVisitsText(SQLiteDatabase sqLiteDatabase) {

        String name = "Tenaris";
        String text = "Tenaris ofrece tecnología de productos avanzada y servicios de " +
                "gestión de supply chain integrados a escala global a clientes tales " +
                "como las principales compañías de petróleo y gas más importantes " +
                "del mundo y a empresas de ingeniería e industriales. " +
                "Tenaris es líder mundial en conexiones premium, y está a la " +
                "vanguardia en el desarrollo de tecnologías tubulares necesarias no " +
                "sólo para operar en los campos de petróleo y gas más complejos, sino " +
                "también en aplicaciones estructurales y mecánicas de alto " +
                "rendimiento. Constituida en Luxemburgo, Tenaris cotiza en las bolsas " +
                "de valores de Milán, Buenos Aires y México; sus acciones bajo la " +
                "forma de American Depositary Securities (ADS) cotizan en la Bolsa de " +
                "Valores de Nueva York. Tenaris cumple con estándares de " +
                "responsabilidad corporativa, transparencia financiera y publicación de " +
                "información.";
        String  web= "http://www.tenaris.com/es-ES/tenarisworldwide/southamerica/argentina.aspx";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

         name = "Bayer";
         text = "Bayer es una compañía de Ciencias de la Vida con una historia de más " +
                 "de 150 años y competencias básicas en las áreas de cuidados de la " +
                 "salud y agricultura. Con sus productos innovadores, estan " +
                 "contribuyendo a encontrar soluciones a algunos de los principales " +
                 "desafíos de nuestro tiempo. Una población mundial en crecimiento y " +
                 "cada vez más longeva requiere atención médica mejorada y un " +
                 "suministro adecuado de alimentos. Bayer está mejorando la calidad " +
                 "de vida de las personas mediante la prevención, alivio y tratamiento " +
                 "de enfermedades. Y estan ayudando a proporcionar un suministro " +
                 "fiable de alimentos de alta calidad, piensos y materias primas de " +
                 "origen vegetal";
        web= "http://www.bayer.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

         name = "Unilever";
         text = "Unilever produce y vende productos bajo el nombre de 400 marcas a " +
                "nivel mundial. Cada día, dos mil millones de personas utilizan " +
                "productos de Unilever para verse bien, sentirse bien y sacarle más " +
                "provecho a la vida. Siete de cada diez hogares en el mundo tienen al " +
                "menos un producto Unilever. Nuestras marcas líderes: Lipton, Knorr, " +
                "Dove, Axe, Hellmann's y Omo. Cualquiera que sea la marca, donde sea " +
                "que se compre, Unilever busca garantizar que ayude a cumplir su " +
                "propósito como empresa: hacer de la sostenibilidad algo cotidiano";
         web= "http://www.unilever.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);
        
        name="La Fármaco";
        text="Es una compañía que ofrece productos cosméticos de calidad y " +
                "brinda soluciones para las necesidades diarias de cuidado e higiene " +
                "personal.";
        web="http://www.lafarmaco.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Femsa";
        text="FEMSA es una empresa líder que participa en la industria de bebidas" +
                "operando Coca-Cola FEMSA, el embotellador público más grande de" +
                "productos Coca-Cola en el mundo; y en el sector cervecero como el" +
                "segundo accionista más importante de Heineken, una de las" +
                "cerveceras líderes en el mundo con presencia en más de 70 países.";
        web="http://www.coca-colafemsa.com/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Cesvi";
        text="Es una empresa dedicada a la investigación, experimentación y" +
                "análisis de la seguridad vial y automotriz. Desde 1996 analizan" +
                "siniestros graves, estudian las causas que los generan y evaluan la" +
                "seguridad de los autos y rutas del país. Todo este conocimiento se" +
                "aplica en las capacitaciones de conducción segura y en los programas" +
                "de educación vial destinados a niños y adolescentes. Además, CESVI" +
                "ARGENTINA contribuye informando a la sociedad mediante la" +
                "publicación de las investigaciones realizadas.";

        web="http://www.cesvi.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="I-Flow";
        text="I-Flow es una empresa creada para Co-Gerenciar y operar las cadenas" +
                "de abastecimiento de sus clientes en Argentina y MERCOSUR." +
                "Es una única fuente para soluciones logísticas integrales. Basa su" +
                "actividad en tres elementos: " +
                "*Capacidad de reformular procesos" +
                "*Gestión operativa" +
                "*Sistemas de gestión" +
                "Su Unidad de Comercio Internacional se encuentra exclusivamente" +
                "dedicada al transporte terrestre entre Argentina, Brasil, Chile y el" +
                "resto del MERCOSUR, creando condiciones de servicio que hacen que" +
                "la atención sea prácticamente personalizada.";

        web="http://www.iflow21.com/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Galvasa";
        text="GALVASA S.A., una empresa de capitales nacionales, participa desde" +
                "hace treinta años en el mercado del galvanizado por inmersión en" +
                "caliente. La planta de producción, de 2.000 m2, está ubicada a pocas" +
                "cuadras de la ruta Panamericana (Autopistas del Sol; Acceso Norte)," +
                "en la localidad de Munro, partido de Vicente López." +
                "La empresa posee un sistema de galvanización para piezas pequeñas" +
                "y roscadas, por sistema de centrifugado." +
                "Las materias primas utilizadas en GALVASA no afectan el equilibrio del" +
                "medio ambiente. La compañía participa del programa de producción" +
                "limpia y competitividad empresarial, auspiciado por la Secretaría de" +
                "Ambiente y Desarrollo Sustentable de la Nación.";

        web="http://www.galvasa.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Sabic";
        text="SABIC’s Innovative Plastics business es líder mundial en el suministro\n" +
                "de soluciones de materiales termoplásticos de ingeniería. En más de\n" +
                "35 países de todo el mundo, ayuda a los fabricantes de equipos\n" +
                "originales a redefinir el diseño, desde el concepto hasta la realidad.\n" +
                "SABIC’s Innovative Plastics business suministra información,\n" +
                "tecnología y soluciones avanzadas de materiales para satisfacer las\n" +
                "necesidades de los clientes de todo el mundo.";

        web="http://www.sabic.com";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Techo";
        text="En 1997 un grupo de jóvenes comenzó a trabajar por el sueño de\n" +
                "superar la situación de pobreza en la que vivían millones de personas.\n" +
                "El sentido de urgencia en los asentamientos los movilizó\n" +
                "masivamente a construir viviendas de emergencia en conjunto con\n" +
                "las familias que vivían en condiciones inaceptables y a volcar su\n" +
                "energía en busca de soluciones concretas a las problemáticas que las\n" +
                "comunidades afrontaban cada día.\n" +
                "Esta iniciativa se convirtió en un desafío institucional que hoy se\n" +
                "comparte en todo el continente. Desde sus inicios en Chile, seguido\n" +
                "por El Salvador y Perú, la organización emprendió su expansión bajo\n" +
                "el nombre “Un Techo para mi País”.";

        web="http://www.techo.org";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Inti";
        text="El INTI fue creado en el marco del surgimiento de un conjunto de\n" +
                "instituciones nacionales destinadas a poner en movimiento, de\n" +
                "manera planificada, la inversión pública, la ciencia y la tecnología.\n" +
                "Sus primeros laboratorios se ubicaron en el Parque Tecnológico\n" +
                "Miguelete en un predio de 19 hectáreas en el Partido de General San\n" +
                "Martín, provincia de Buenos Aires, en el que hoy se concentran una\n" +
                "treintena de centros, además de áreas administrativas y de soporte.\n" +
                "Hoy el INTI está presente con Centros Regionales y Multipropósito en\n" +
                "todo el país, que generan investigación y desarrollo en red, con el fin\n" +
                "de acompañar e impulsar el crecimiento industrial de cada provincia.";

        web="http://www.inti.gob.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Ruhrpumpen";
        text="Ruhrpumpen es una empresa dedicada a la fabricación de bombas\n" +
                "centrífugas cuyos principales mercados son la petroquímica, la\n" +
                "minería, la industria, la energía, los productos químicos y la\n" +
                "prevención de aguas residuales.\n" +
                "En el día de hoy Ruhrpumpen cuenta con instalaciones, oficinas de\n" +
                "ventas y centros de servicio ubicados en Alemania, México, Estados\n" +
                "Unidos, la fabricación de Egipto , Argentina , Brasil , India, Rusia,\n" +
                "Canadá, Colombia y Chile.";

        web="http://www.ruhrpumpen.com";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Dana";
        text="Dana es un líder mundial en suministro de ejes diferenciales; ejes\n" +
                "cardán; transmisiones para fuera de carretera; sistemas de sellado,\n" +
                "productos de gestión térmica y piezas de repuesto originales. Su\n" +
                "posición en el mercado se construyó a partir de algunas de las marcas\n" +
                "más sólidas del sector, trabajando para ampliar aún más el legado de\n" +
                "larga data de Dana en desempeño, innovación, durabilidad, calidad y\n" +
                "servicio de posventa.";

        web="http://www.dana.com.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Genrod";
        text="Genrod es parte de la Industria metalúrgica y plástica dedicada a la\n" +
                "fabricación y desarrollo de sistemas integrales de canalización y\n" +
                "envolventes para instalaciones eléctricas.\n" +
                "Fabrica y comercializa gabinetes, cajas y envolventes de usos\n" +
                "múltiples, desarrollados en termoplásticos aislantes y metálicos.\n" +
                "Utilizados para la construcción de instalaciones eléctricas\n" +
                "domiciliarias, industriales en general y para la distribución, y medición\n" +
                "de energía en baja tensión.\n" +
                "Produce además múltiples accesorios del Sistema Integral de\n" +
                "Instalación Eléctrica desarrollado e impulsado por la empresa como\n" +
                "así también elementos necesarios para puesta a tierra.";

        web="http://www.genrod.com.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Loreal";
        text="Durante más de un siglo , L' Oréal se ha dedicado a un único negocio :\n" +
                "la belleza. Es un negocio rico en significado, ya que permite a los\n" +
                "individuos expresar sus personalidades, ganar confianza en sí mismos\n" +
                "y abrirse a los demás.\n" +
                "L' Oréal se ha impuesto a sí mismo la misión de ofrecer a todas las\n" +
                "mujeres y hombres del mundo lo mejor de la innovación cosmética en\n" +
                "términos de calidad , eficacia y seguridad . Persigue este objetivo\n" +
                "mediante el cumplimiento de la infinita diversidad de necesidades y\n" +
                "deseos de belleza en todo el mundo.";

        web="http://www.loreal.com.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Metalsa";
        text="Dentro de la industria automotriz y vehículos comerciales Metalsa ha\n" +
                "probado ser una de las mejores opciones en la solución de\n" +
                "componentes estructurales para vehículos ligeros y pesados.\n" +
                "Siendo una empresa global, Metalsa cuenta con operaciones y\n" +
                "centros de tecnología localizados estratégicamente alrededor del\n" +
                "mundo, proporcionando un soporte integral a sus clientes a través de\n" +
                "un servicio inigualable.";

        web="http://www.metalsa.com";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="MercadoLibre";
        text="MercadoLibre es una empresa argentina dedicada a las compras entre\n" +
                "usuarios inscritos a su servicio de compras, ventas y pagos por\n" +
                "Internet. Cuenta con operaciones en su país de origen, así como\n" +
                "en Bolivia, Brasil, Chile, Colombia, Costa\n" +
                "Rica, Ecuador, Guatemala, México, Panamá, Perú, Portugal, República\n" +
                "Dominicana, Uruguay, Honduras y Venezuela.\n" +
                "Los usuarios pueden vender tanto productos nuevos como usados a\n" +
                "precio fijo. MercadoLibre también posee MercadoPago, una\n" +
                "plataforma de cobro a los vendedores. Sus oficinas centrales se\n" +
                "encuentran en Buenos Aires, Argentina.";

        web="http://www.mercadolibre.com.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Edelflex";
        text="Desde su creación en el año 2004, Edelflex S.A. es referente en\n" +
                "numerosas industrias como proveedor de componentes y sistemas\n" +
                "de manejo de fluidos. Es parte del proceso productivo aportando su\n" +
                "experiencia y enfoque en la innovación, brindando ideas y soluciones\n" +
                "inteligentes para industrias que requieren de tecnología avanzada.";

        web="http://www.edelflex.com";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Valmec";
        text="Desde el comienzo de sus actividades, VALMEC S.A. tiene como\n" +
                "objetivo principal brindar a los clientes un producto de excelencia\n" +
                "para el control de fluidos, considerando las mejoras continuas, la\n" +
                "tecnología de punta y su integración con el personal, como las bases\n" +
                "fundamentales de una estructura eficiente, que es el fiel reflejode la\n" +
                "misión y los valores de la organización.\n" +
                "La visión de VALMEC S.A. se fundamenta en la innovación tecnológica\n" +
                "constante y el desarrollo profesional de su equipo de trabajo, siendo\n" +
                "estos los elementos inspiradores para el alcance de nuevas\n" +
                "soluciones, seguras y confiables con elevados estándares de calidad.\n" +
                "Actualmente, VALMEC S.A. es un actor importante en el mercado\n" +
                "Latinoamericano y local, encontrándose posicionada entre las líderes\n" +
                "del sector, lo cual constituye proyecciones de expansión hacia el\n" +
                "resto del mundo.";

        web="http://www.valmec.com.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Droguería del Sud";
        text="Droguería del Sud es la Distribuidora integral a farmacias número uno\n" +
                "del país (medicamentos, productos de perfumería y alimentos\n" +
                "medicamentados) líder en tecnología aplicada a la logística y\n" +
                "distribución.\n" +
                "Droguería del Sud fue fundada en 1950 por el Dr. Silvio Macchiavello,\n" +
                "quien adquirió una pequeña droguería situada en la calle México 1932,\n" +
                "que contaba con apenas 20 clientes y 6 empleados. Al año siguiente,\n" +
                "la compañía ya tenía 40 empleados, 200 clientes y operaba con todos\n" +
                "los laboratorios del país. En 1967, Droguería del Sud se muda al\n" +
                "edificio de la calle Humberto Primo donde hoy funciona su casa\n" +
                "central.\n" +
                "En la década del 80, la Droguería comienza a expandirse\n" +
                "geográficamente. En 1988 se inaugura la primera Sucursal: Córdoba,\n" +
                "hoy la mayor de las 7 dependencias con que cuenta.\n" +
                "En 1994 la sede de Buenos Aires se convierte en la primera planta de\n" +
                "distribución totalmente automatizada a nivel mundial.También ese\n" +
                "año se inaugura la segunda sucursal de la compañía en Santo Tomé\n" +
                "(provincia de Santa Fe). En 1999 se producen dos nuevas aperturas:\n" +
                "Corrientes y Bahía Blanca, ampliando considerablemente su volumen\n" +
                "de negocios con una fuerte mejora en el nivel de servicios a los\n" +
                "clientes del interior del país. En el nuevo siglo, la compañía se sigue\n" +
                "ampliando a partir de la apertura de sus Centros en Neuquén (hoy en\n" +
                "día trasladado a Allen, en la Provincia de Rio Negro), Mendoza y Mar\n" +
                "del Plata. Actualmente Droguería del Sud S.A es la mayor y más\n" +
                "importante droguería de la República Argentina y se encuentra entre\n" +
                "las 50 empresas de mayor facturación del país.";

        web="http://www.delsud.com.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Globant";
        text="Globant es una empresa de desarrollo de software y TI que opera en\n" +
                "Argentina, Colombia, Uruguay, Reino Unido, Brasil, Estados Unidos,\n" +
                "Perú, India, México, Chile y España. Fue fundada en 2003 por Martín\n" +
                "Migoya, Guibert Englebienne, Martín Umaran y Néstor Nocetti. Tiene\n" +
                "su sede en Buenos Aires y sirve principalmente clientes en los\n" +
                "Estados Unidos y el Reino Unido.";

        web="http://www.globant.com/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Banco Alimentario de La Plata";
        text="Es una Organización de la Sociedad Civil (OSC), que tiene como\n" +
                "objetivo disminuir el hambre y la desnutrición a través del recupero\n" +
                "de alimentos.\n" +
                "Nació como Asociación Civil sin fines de lucro en el año 2000, como\n" +
                "en el primer Banco de Alimentos del país.\n" +
                "Son socios fundadores de la Red Argentina de Bancos de Alimentos,\n" +
                "que nuclea a otros 16 Bancos constituidos en el país y 2 en formación.\n" +
                "Defienden el Derecho Humano a una alimentación saludable, logrado\n" +
                "a través del esfuerzo de su staff, voluntarios y la solidaridad de\n" +
                "empresarios, productores y donantes.";

        web="http://bancoalimentario.org.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Tigre";
        text="Multinacional brasileña, líder en los diversos mercados en los que\n" +
                "actúa, Tigre es sinónimo de pionerismo e innovación. La marca ofrece\n" +
                "productos que atienden los mercados predial, de infraestructura, de\n" +
                "riego e industrial. El grupo está presente en aproximadamente 40\n" +
                "países, posee siete mil funcionarios, 9 plantas en Brasil y 13 en el\n" +
                "exterior. Además de tubos y conexiones, también forman parte del\n" +
                "portafolio las marcas Claris Soluções em Esquadrias, Tigre\n" +
                "Herramientas para Pintura y Tigre-ADS, con tuberías de PEAD para\n" +
                "saneamiento y drenaje.";

        web="http://www.tigre.com.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Sandvik";
        text="Sandvik es un grupo de ingeniería de alta tecnología y global con\n" +
                "cerca de 43.000 empleados con un fuerte compromiso de mejorar la\n" +
                "productividad, rentabilidad y seguridad del cliente.\n" +
                "Sus operaciones se basan en una experiencia única en tecnología de\n" +
                "materiales, un amplio conocimiento de los procesos industriales y una\n" +
                "estrecha cooperación con los clientes. Esta combinación, sumada a\n" +
                "las continuas inversiones en investigación y desarrollo (I + D), les ha\n" +
                "permitido alcanzar posiciones de liderazgo mundial en las siguientes\n" +
                "áreas:\n" +
                "\uF0B7 Herramientas y sistemas de herramientas para corte industrial\n" +
                "de metales\n" +
                "\uF0B7 Equipos y herramientas, servicios y soluciones técnicas para la\n" +
                "industria minera y de la construcción\n" +
                "\uF0B7 Aceros inoxidables avanzados y aleaciones especiales, así como\n" +
                "productos para calefacción industrial";

        web="http://www.home.sandvik/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Telefónica";
        text="Telefónica, SA es una empresa española multinacional de banda\n" +
                "ancha y telecomunicaciones con operaciones en Europa, Asia y Norte,\n" +
                "América Central y del Sur. Operando a nivel mundial, es uno de los\n" +
                "mayores operadores de telefonía y proveedores de redes móviles en\n" +
                "el mundo.";

        web="http://www.telefonica.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Peisa";
        text="LA EMPRESA PEISA inicia sus actividades en el año 1979. Introdujo en\n" +
                "el país el primer radiador de aluminio para calefacción, producto de\n" +
                "elevada tecnología y diseño europeo, hasta el momento desconocido\n" +
                "en nuestro país.\n" +
                "En el año 1982 se desarrollan productos que hasta entonces eran\n" +
                "importados. Nace así el primer radiador de aluminio inyectado\n" +
                "fabricado en Argentina y Latinoamérica. Este producto de alta calidad\n" +
                "fue íntegramente fabricado en el país y se alcanzó la calidad de los\n" +
                "productos italianos lo mismo ocurrió con las calderas individuales\n" +
                "para calefacción.\n" +
                "A estos desarrollos le sucedieron otros, que hoy completan la línea de\n" +
                "productos PEISA, la más amplia obtenible en el Mercado Nacional.\n" +
                "Hoy cuenta con una fabrica propia de 2.500 m2, en Parque Patricios y\n" +
                "un importante edificio en Av. del Libertador y Congreso (Nuñez),\n" +
                "donde tiene su Showroom y las oficinas de administración.";

        web="http://www.peisa.com.ar";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Pirelli";
        text="Pirelli & CSpA es una empresa multinacional con sede en Milán, Italia.\n" +
                "La compañía es uno de los mayores fabricantes de neumáticos. Está\n" +
                "presente en más de 160 países, tiene 19 centros de fabricación [4] en\n" +
                "13 países y una red de alrededor de 12.500 distribuidores y minoristas.\n" +
                "Pirelli ha patrocinado competiciones deportivas desde 1907 y es el\n" +
                "proveedor exclusivo de neumáticos para el Campeonato de Fórmula\n" +
                "Uno y para el Campeonato Mundial de Superbikes FIM.";

        web="http://www.pirelli.com";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Du Pont";
        text="Un Líder Mundial en Innovación y Ciencia Basadas en el Mercado. Con\n" +
                "una experiencia que abarca dos siglos, diversas industrias y más de 90\n" +
                "países, La empresa está exclusivamente posicionada para ayudar a\n" +
                "resolver algunos de los desafíos más grandes del mundo. DuPont ha\n" +
                "llevado la ciencia y la ingeniería de clase mundial al mercado global a\n" +
                "través de productos, materiales y servicios innovadores. Nuestra\n" +
                "innovación basada en el mercado presenta miles de productos\n" +
                "nuevos y aplicaciones de patentes cada año, con lo que presta\n" +
                "servicios a mercados tan diversos como la agricultura, la nutrición, la\n" +
                "electrónica y las comunicaciones, la seguridad y la protección, el\n" +
                "hogar y la construcción, el transporte y la ropa.";

        web="http://www.dupont.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="CNEA";
        text="El 31 de mayo de 1950, mediante el Decreto Nº 10.936/50, el\n" +
                "Presidente Juan Perón creó la Comisión Nacional de Energía Atómica\n" +
                "(CNEA). Desde entonces, la institución se dedica al estudio, al\n" +
                "desarrollo y a las aplicaciones en todos los aspectos vinculados con la\n" +
                "utilización pacífica de la energía nuclear. Hoy es el organismo\n" +
                "promotor del área en nuestro país.\n" +
                "La Argentina se destaca por impulsar el uso de la energía nuclear con\n" +
                "fines pacíficos, apostando a la investigación y a la innovación en el\n" +
                "ámbito nuclear. De hecho, desde su creación hace más de 60 años, la\n" +
                "CNEA aporta logros de importancia, que acompañan y contribuyen al\n" +
                "crecimiento del país, de la región e incluso de la ciencia en todo el\n" +
                "mundo.\n" +
                "En la actualidad, la CNEA avanza en la construcción del proyecto\n" +
                "CAREM, primera central de diseño 100 % argentino.\n" +
                "El liderazgo a nivel regional también se observa en el campo de la\n" +
                "medicina nuclear y, muy particularmente, en el de la producción de\n" +
                "radioisótopos. Cabe destacar que la CNEA produce el molibdeno-99,\n" +
                "e incluso exporta otros radioisótopos —como el iodo-131 y el cobalto-\n" +
                "60— que contribuyen al tratamiento de ciertos tipos de cáncer.";

        web="http://www.cnea.gov.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Galfione";
        text="La visita abordará la seguridad en instalaciones electricas industriales\n" +
                "y domiciliarias poniendo enfasis en la automatizacion logica cableada.\n" +
                "Los orígenes de la Empresa Galfione y CIA S.R.L. se remontan\n" +
                "alrededor del año1947, cundo e Sr Hugo Galfione y su madre, la Sra.\n" +
                "Josefina Ciliario compraron una fábrica de medias, ubicada en Capital\n" +
                "Federal; en ese entonces ocupaba un solo lote y era alquilado, más\n" +
                "tarde será adquirido.\n" +
                "A partir de los años ´50, se incorporó la producción de hilados para\n" +
                "su propio consumo, creciendo la demando de hilados, en detrimento\n" +
                "de las medias. También por esos años trae la marca “Helenca”, siendo\n" +
                "los primeros texturizadores del país. A principio de los ´90 se\n" +
                "incorporan máquinas para producir hilados de lycra y equipos para el\n" +
                "retorcido de hilados y para la producción de hilados de fantasía. En\n" +
                "1996 se incorporan nuevas máquinas de última generación con una\n" +
                "producción mensual de 40 toneladas.\n" +
                "Actualmente la empresa se encuentra operando en su nuevo\n" +
                "domicilio de Ferré 2770, donde construyo una nueva planta industrial\n" +
                "en el año 2001, con los últimos adelantos de la materia tanto de\n" +
                "funcionalidad desde el punto de vista del lay-out, como desde el\n" +
                "punto de vista de seguridad.";

        web="http://www.galfioneycia.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="TRF";
        text="Desde 1972, en TRF brinda soluciones logísticas integrales de primer\n" +
                "nivel a cada uno de sus clientes. Con TRF, tercerizar resulta fácil\n" +
                "porque es un socio estratégico en la distribución segura y eficaz de\n" +
                "los productos que le confía cada cliente. Sus unidades de negocio son\n" +
                "dos: Abastecimiento y preparación, y Distribución. Ofrece recepción y\n" +
                "retiro de productos, almacenamiento y administración de stock,\n" +
                "preparación de pedidos y entrega al destinatario final en todo el país.\n" +
                "Asimismo, nos ocupamos del acondicionamiento secundario que\n" +
                "implica el reembalaje y etiquetado de los productos de acuerdo a los\n" +
                "requisitos del ANMAT. Estamos para lo que necesites.";

        web="http://www.metalsa.com";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Pura";
        text="Pura es Empresa Líder en Tratamiento y Purificación de Aguas.\n" +
                "Contamos con tecnologías exclusivas de desarrollo propio. Cuentan\n" +
                "con el respaldo y enfoque global de AISA IONIC Technologies, con\n" +
                "más de 30 años de trayectoria en investigación y desarrollo. Cada\n" +
                "equipo Pura está avalado por el Ministerio de Salud y Anmat, como\n" +
                "también sus procesos de trabajo bajo Normas ISO 9001. Permitiendo\n" +
                "que sus productos tengan Garantía de por Vida. Mediante sus\n" +
                "laboratorios propios, conocen todas las calidades de agua de nuestro\n" +
                "país y Latinoamérica, lo que les permite brindar soluciones a medida\n" +
                "para toda escala, Hogares, Comunidades, Negocios e Industrias.\n" +
                "Cuentan con el equipo de trabajo más especializado, y la mayor\n" +
                "solidez técnica. Los productos Pura deben facilitar la vida a quien los\n" +
                "usa. Por eso adaptan soluciones fácil de instalar, de mantener, de\n" +
                "poner en marcha y de usar.";

        web="http://pura.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Schneider Electric";
        text="Schneider Electric está presente en Argentina presente desde 1982.\n" +
                "En su planta industrial fabrican soluciones y productos de media y\n" +
                "baja tensión, cumpliendo con los más exigentes estándares\n" +
                "internacionales de calidad y eficiencia en los procesos de\n" +
                "manufactura. Proveen al mercado interno y destinan a la exportación\n" +
                "un 40% de su producción.";

        web="http://www.schneider-electric.com.ar/es/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Cervecería y Maltería Quilmes";
        text="Cervecería y Maltería Quilmes forma parte de Anheuser-Busch InBev,\n" +
                "la compañía cervecera internacional líder y una de las cuatro\n" +
                "empresas de consumo masivo más grandes del mundo, con sede en\n" +
                "Leuven, Bélgica. Anheuser-Busch InBev cuenta con un portfolio de\n" +
                "más de 200 marcas y con operaciones en más de 23 países.\n" +
                "Cervecería y Maltería Quilmes es una de las compañías de bebidas\n" +
                "más importantes de la región. Produce, elabora, distribuye y\n" +
                "comercializa cervezas, gaseosas, aguas minerales, jugos e isotónicos,\n" +
                "en alianza con empresas internacionales líderes como PepsiCo y\n" +
                "Nestlé. Cervecería y Maltería Quilmes es líder en la categoría cervezas\n" +
                "con alrededor del 75% del mercado y cuenta con una participación del\n" +
                "mercado total de bebidas cercano al 30%, entre sus participaciones\n" +
                "en cervezas, gaseosas y aguas.";

        web="http://www.quilmes.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Laminados Reforzados";
        text="En laminados reforzados su principal actividad es el procesamiento\n" +
                "de piezas realizadas con plásticos reforzados con fibra de vidrio y\n" +
                "resinas. No fabrica solamente piezas, si no que agrega valor al\n" +
                "proceso. Se prevé el montaje, obteniéndose una pieza y una solución.\n" +
                "Realizan componentes, lo que incluye su estudio para que sean\n" +
                "productivos a la hora del ensamble. Su cadena logística, y su\n" +
                "reposición y reparación.";

        web="http://www.laminadosreforzados.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Gersolar";
        text="La visita constará de tres partes, donde se visitará al Grupo Gersolar,\n" +
                "dedicado al Asesoramiento, capacitación y difusión acerca de la\n" +
                "distribución espacio-temporal de la irradiación solar global incidente\n" +
                "sobre la superficie terrestre. Tambíen se visitará la planta piloto\n" +
                "donde se realizan quesos y otros productos lácteos, y los tambos que\n" +
                "posee la universidad.";

        web="http://www.gersol.unlu.edu.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Metalsa";
        text="Dentro de la industria automotriz y vehículos comerciales Metalsa ha\n" +
                "probado ser una de las mejores opciones en la solución de\n" +
                "componentes estructurales para vehículos ligeros y pesados.\n" +
                "Siendo una empresa global, Metalsa cuenta con operaciones y\n" +
                "centros de tecnología localizados estratégicamente alrededor del\n" +
                "mundo, proporcionando un soporte integral a sus clientes a través de\n" +
                "un servicio inigualable.";

        web="http://www.metalsa.com";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="UNLP";
        text="La universidad cuenta con bancos de prueba para la certificación de\n" +
                "turbinas, a escala 1:1. Se visitará uno de los laboratorios de Hidraulica\n" +
                "más grandes del país. A su vez se realizará una visita al laboratorio de\n" +
                "Alta Tensión.";

        web="http://www.unlp.edu.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="FRD";
        text="Se realizará una visita técnica a los laboratorios de Mecánica,\n" +
                "Biotecnología, Nanotecnología y Óptica, apreciando equipamiento\n" +
                "diseñado por la propia universidad, e indagando sobre los grupos de\n" +
                "investigación que funcionan allí.";

        web="http://www.frd.utn.edu.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Trimak";
        text="Trimak es una empresa formada en el año 1966 por un grupo familiar\n" +
                "con amplios conocimientos técnicos en la elaboración de galletitas y\n" +
                "budines.\n" +
                "En los comienzos estuvimos abocados a la producción de pepas y\n" +
                "scons; la constante superación nos ha permitido a través de los años\n" +
                "aplicar nuevas y modernas tecnologías, las cuales han hecho que\n" +
                "nuestra línea de productos creciera, pudiendo ofrecer hoy una amplia\n" +
                "variedad de galletitas dulces (muchas de ellas bañadas con un\n" +
                "exquisito chocolate de repostería), alfajores y budines (los cuales son\n" +
                "elaborados durante todo el año).\n" +
                "Nuestra producción esta cuidadosamente supervisada, por personal\n" +
                "especializado que realiza un exhaustivo control tanto en las materias\n" +
                "primas como en los productos finales, para acercarles a ustedes la\n" +
                "mejor calidad.";

        web="http://www.trimak.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Gottert";
        text="Diseñamos, fabricamos, comercializamos y brindamos servicios de\n" +
                "montaje y asistencia técnica de equipos propios y marcas que\n" +
                "representamos. Brindando atención personalizada con pilares en:\n" +
                "flexibilidad, desarrollo profesional, satisfacción del cliente, ética y\n" +
                "compromiso social y confiabilidad. Somos una empresa líder en\n" +
                "soluciones para la industria ofreciendo equipamientos para el\n" +
                "tratamiento de superficies, movimiento de materiales, industria de la\n" +
                "madera y equipos especiales.";

        web="http://www.gottert.com.ar/empresa";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Spirax Sarco";
        text="Como proveedor líder de soluciones para el sistema de vapor, Spirax\n" +
                "Sarco es el nombre que primero viene a la mente cuando los\n" +
                "ingenieros en cualquier lugar del mundo piensan en ‘vapor’. La razón\n" +
                "es que nuestro prestigio está construido sobre un siglo de experiencia\n" +
                "y presencia global con más de 1.300 ingenieros de la industria en 34\n" +
                "países diferentes.\n" +
                "Estamos comprometidos a ayudarle a mejorar el rendimiento de su\n" +
                "planta, a cumplir con la legislación, a alcanzar sus metas y a\n" +
                "mantenerse un paso adelante de sus competidores.\n" +
                "Desde el diseño, la instalación y la puesta en servicio de nuevas\n" +
                "instalaciones y la optimización y actualización de los sistemas de\n" +
                "vapor existentes hasta mantener el desempeño de planta por medio\n" +
                "del mantenimiento programado, contamos con la experiencia, los\n" +
                "recursos, los productos y los servicios para ayudarlo a alcanzar un\n" +
                "crecimiento rentable.";

        web="http://www.spiraxsarco.com/global/ar/Pages/About-Us.aspx";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Industrias Guidi";
        text="Somos empresa familiar de capitales nacionales fundada por Fernand\n" +
                "Guidi en 1960 dedicada a la fabricación de autopartes, como paneles\n" +
                "de capot, paragolpes, paneles de piso, entre otras. Reconocemos la\n" +
                "necesidad de realizar mejoras continuas en todos nuestros procesos\n" +
                "para hacer frente al desafio de la competencia global de mercados.\n" +
                "En este sentido, los objetivos propuestos año a año en materia de\n" +
                "Seguridad, Calidad, Costos y Productividad son siempre desafiantes.";

        web="http://www.industriasguidi.com.ar/esp/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Cartocor";
        text="Somos una empresa con una visión clara, inclusiva e integradora;\n" +
                "trabajamos sobre estrategias apoyadas en un sistema innovador, la\n" +
                "continua evolución y la idea de ser parte de un mundo mejor.\n" +
                "La integración de las empresas Cartocor y Converflex es un resultado\n" +
                "natural, basado en los fuertes valores compartidos, como pilares\n" +
                "fundamentales de la evolución.\n" +
                "Vivimos la etapa anterior como la apertura a las oportunidades y ésta,\n" +
                "como una etapa donde convergen la experiencia individual, los\n" +
                "conocimientos adquiridos y el capital humano, puestos al servicio de\n" +
                "un nuevo ciclo lleno de sueños por cumplir.\n" +
                "La sinergia de Cartocor, una empresa enfocada en la fabricación y\n" +
                "comercialización de cartón corrugado, y Converflex, especializada en\n" +
                "los empaques flexibles, permite que hoy podamos verlas como una\n" +
                "compañía sólida de empaque, con un enfoque más abarcador y la\n" +
                "posibilidad de ofrecer al cliente soluciones integrales, sostenidas por\n" +
                "el trabajo cooperativo.";

        web="http://www.cartocor.com/cartocor/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="Escuela Técnica 29";
        text="La visita abordará la seguridad en instalaciones electricas industriales"+
        "y domiciliarias poniendo enfasis en la automatizacion logica cableada";
        web="http://www.tecnica29.org/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);




        name="Dimare";
        text="Dimare SA somos una pyme familiar dedicada a fabricar juguetes. Fue\n" +
                "fundada en 1965 por Antonio Dimare y actualmente se encuentra bajo\n" +
                "su directiva junto con la de sus cinco hijos, que siguieron su legado.";

        web="http://www.rasti.com.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);

        name="CEAMSE";
        text="CEAMSE es una empresa creada por los estados de la Provincia de\n" +
                "Buenos Aires y la Ciudad de Buenos Aires para realizar la gestión\n" +
                "integral de los Residuos sólidos urbanos del área metropolitana.\n" +
                "Desde su creación hace más de 30 años, desarrolla tareas mediante\n" +
                "los procesos más modernos de gestión ambiental, lo que implica un\n" +
                "compromiso con la investigación e incorporación de nuevos métodos\n" +
                "y tecnologías en la materia.";
        web="http://www.ceamse.gov.ar/";
        insertSpecificVisitText(sqLiteDatabase,name,text,web);


    }

    private void insertSpecificVisitText(SQLiteDatabase sqLiteDatabase, String name, String text,String web) {
        ContentValues visit = new ContentValues();
        visit.put("name", name);
        visit.put("text", text);
        visit.put("web",web);
        sqLiteDatabase.insert("VisitText", null, visit);
    }

    private void insertTurns(SQLiteDatabase sqLiteDatabase) {
        String name = "Tenaris";
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

        name="Bayer";
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

        name="Unilever";
        hour=15;
        minute=45;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        name="La Fármaco";
        hour=15;
        minute=45;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        name="Femsa";
        hour=15;
        minute=45;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        name="Cesvi";
        hour=15;
        minute=45;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        name="I-Flow";
        hour=15;
        minute=45;
        number=1;
        id++;
        insertSpecificTurn(sqLiteDatabase, name, hour, minute,number,id,alarm);

        name="Galvasa";
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
        String name = "Tenaris";
        int duration = 60;
        String address = "Castelli 1331";
        int day = 14;
        int month = 3;
        int year = 2017;
        String place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "Bayer";
        duration = 40;
        address = "Av San Martin 175 - Av. Hip. Irigoyen y Pelegrini";
        day = 13;
        month = 3;
        year = 2017;
        place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "Unilever";
        duration = 90;
        address = "Ruta 144, km 674.5";
        day = 13;
        month = 3;
        year = 2017;
        place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "La Fármaco";
        duration = 90;
        address = "Ruta 144, km 674.5";
        day = 13;
        month = 3;
        year = 2017;
        place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "Femsa";
        duration = 90;
        address = "Ruta 144, km 674.5";
        day = 13;
        month = 3;
        year = 2017;
        place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "Cesvi";
        duration = 90;
        address = "Ruta 144, km 674.5";
        day = 13;
        month = 3;
        year = 2017;
        place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "I-Flow";
        duration = 90;
        address = "Ruta 144, km 674.5";
        day = 13;
        month = 3;
        year = 2017;
        place = "Terminal de ómnibus Nestor Kirchner";

        insertSpecificVisit(sqLiteDatabase, name, duration, address, day, month, year, place);

        name = "Galvasa";
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
