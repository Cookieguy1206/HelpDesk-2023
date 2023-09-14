package Controlador;

import Conexion.*;
import Modelo.*;
import Vista.*;
//import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.mail.*;
import javax.swing.*;
import javax.mail.MessagingException;

public class ControladorRecibirEmail {

    public String Correo;
    public String Sujeto;
    public String Contenido;
    public Message idMensaje;
    public int idPersona;
    ModeloCorreo ModeloCorreo = new ModeloCorreo();

    public ArrayList<ModeloCorreo> RecibirEmail() throws MessagingException, IOException, SQLException /*com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException*/ {

        ArrayList listaCorreos = new ArrayList();
        Properties p = new Properties();
        p.setProperty("mail.store.protocol", "imaps");
        p.setProperty("mail.imaps.partialfetch", "false");
        p.put("mail.imap.ssl.enable", "true");
        p.put("mail.mime.base64.ignoreerrors", "true");

        //Instanciamos la clase Session de JavaMail
        Session sesion = Session.getInstance(p);
        sesion.setDebug(false);

        //Es hora de obtener el Store y el Folder de Inbox (Carpeta de entrada y servidor de correo)
        Store store = sesion.getStore();
        store.connect("imap.gmail.com", 993, "soacrenovado@gmail.com", "Wannabebolso2020");
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        //Obtener los mensajes
        Message[] mensajes = folder.getMessages();

        //Se escribe from y subject de cada una de las partes
        for (int i = 0; i < mensajes.length; i++) {
            System.out.println("---------------------------------");
            System.out.println("From:" + mensajes[i].getFrom()[0].toString());
            System.out.println("Subject:" + mensajes[i].getSubject());
            Multipart mp = (Multipart) mensajes[i].getContent();
            ModeloCorreo.setMp(mp);
            BodyPart bp = mp.getBodyPart(0);
            ModeloCorreo.setBp(bp);

            //Se pone a analizar todas y cada una de las partes del mensaje
            analizaParteDeMensaje(mensajes[i], mensajes[i]);

            //Añadir al ModeloCorreo las partes analizadas
            listaCorreos.add(ModeloCorreo);

            for (idPersona = 1; idPersona < mensajes.length; idPersona++) {

            }
        }
        return listaCorreos;
    }

    //Insertar correo a la BD
    public void InsertarCorreo(String Correo) {
        try {
            Conexion con = new Conexion();
            Connection conexion;
            conexion = con.getConnection();
            idPersona = con.AutoIncrementP();

            PreparedStatement ps = conexion.prepareStatement("INSERT INTO persona(idPersona, CorreoPersona) "
                    + "VALUES(" + idPersona + "," + "?" + ")");
            ps.setString(1, Correo);

            System.out.println("\n" + ps);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error" + ex + "\n");
        }
    }

    //Insertar contenido a la BD
    public void InsertarContenido(String fichero, String Sujeto, String Contenido) {
        try {
            AñadirProblema AñadirProblema = new AñadirProblema();
            VistaTicket VistaTicket = new VistaTicket();
            Conexion con = new Conexion();
            Connection conexion;
            conexion = con.getConnection();
            int idProblemaR = con.AutoIncrement() + 1;
            int idProblema = idProblemaR;
            int idSolucionR = con.AutoIncrementS() + 1;
            int idSolucion = idSolucionR;
            int idAvances = con.AutoIncrementA();
            int idPrioridad = AñadirProblema.JCPrioridad.getSelectedIndex();
            int idAreaProb = AñadirProblema.JCArea.getSelectedIndex();
            int idTipoProb = AñadirProblema.JCTipoSolicitud.getSelectedIndex();
            int idEstado = VistaTicket.JCEstadoTicket.getSelectedIndex();

            PreparedStatement ps = conexion.prepareStatement("INSERT INTO Problema(idProblema, NombreProb, DetalleProb, FechaCreacion, "
                    + "RefIdPrioridad, RefAreaProb, RefTipoProb, RefEstado, RefPersona, RefSolucion, RefAvances, Imagen) "
                    + "VALUES(" + idProblema + ",?, ?, CURRENT_TIMESTAMP," + idPrioridad + "," + idAreaProb + "," + idTipoProb
                    + "," + idEstado + "," + idPersona + "," + idSolucion + "," + idAvances + "," + "?" + ")");
            ps.setString(1, Sujeto);
            ps.setString(2, Contenido);
            ps.setString(3, fichero);

            System.out.println("\n" + ps);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error" + ex + "\n");
        }
    }

    public void InsertarImagen(String fichero) throws SQLException, IOException {
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();
        int idProblemaR = con.AutoIncrementRI();
        int idProblema = idProblemaR;

        PreparedStatement ps = conexion.prepareStatement("UPDATE Problema SET Imagen = ? "
                + "WHERE idProblema = " + idProblema + "");
        ps.setString(1, fichero);
        System.out.println("Imagen guardada");
        System.out.println(ps);
        ps.executeUpdate();
    }

    public void Verificacion(Message mensaje, String Correo, String Sujeto, String Contenido) throws SQLException, MessagingException /*com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException*/ {
        ConsultasProblema Problema = new ConsultasProblema();
        if (Problema.BuscaRepetido(mensaje) == 0) {
            System.out.println("idMensaje " + mensaje + " No existe: Agregando...");
            InsertarCorreo(Correo);
            String fichero = "No Imagen";
            InsertarContenido(fichero, Sujeto, Contenido);
        } else {
            System.out.println("Correo " + Correo + " Existe\n");
        }
    }

    public void MostarImagen(VistaTicket VistaTicket, VistaImagen VistaImagen) throws SQLException {
        //VistaImagen VistaImagen = new VistaImagen();
        //VistaTicket VistaTicket = new VistaTicket();
        
        //try {
            //String Ruta = VistaTicket.TxtRutaImagen.getText();
            //Process process = Runtime.getRuntime().exec("cmd /c start " + Ruta);
            //BufferedReader BR = new BufferedReader(new InputStreamReader(process.getInputStream()));

        //} catch (IOException ex) {
            //ex.printStackTrace();
        //}
    }

    public void analizaParteDeMensaje(Part unaParte, Message mensaje) throws SQLException /*com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException*/ {
        try {
            //Si es multipart, se analiza cada una de sus partes recursivamente
            if (unaParte.isMimeType("multipart/*")) {
                Multipart multi;
                multi = (Multipart) unaParte.getContent();

                for (int j = 0; j < multi.getCount(); j++) {
                    analizaParteDeMensaje(multi.getBodyPart(j), mensaje);
                }
            } else {
                //Solo toma el texto plano del correo y guardalo
                if (unaParte.isMimeType("text/plain")) {
                    System.out.println("Tipo de contenido " + unaParte.getContentType());
                    System.out.println("Contenido " + unaParte.getContent());
                    System.out.println("---------------------------------");

                    ModeloCorreo.setContenido(unaParte.getContent().toString());
                    ModeloCorreo.setCorreo(mensaje.getFrom()[0].toString());
                    ModeloCorreo.setIdMensaje(mensaje);
                    ModeloCorreo.setSujeto(mensaje.getSubject());

                    idMensaje = ModeloCorreo.getIdMensaje();
                    Correo = ModeloCorreo.getCorreo();
                    Sujeto = ModeloCorreo.getSujeto();
                    Contenido = ModeloCorreo.getContenido();

                    Verificacion(idMensaje, Correo, Sujeto, Contenido);
                } else {
                    //Si es imagen, se guarda en fichero
                    if (unaParte.isMimeType("image/*")) {
                        System.out.println("Imagen " + unaParte.getContentType());
                        System.out.println("Fichero = " + unaParte.getFileName());
                        System.out.println("---------------------------------");

                        //Guardar la imagen en el PC para despues tomar la ruta y guardarla en la BD
                        FileOutputStream guardarFichero = new FileOutputStream("C:\\Users\\admon\\Documents\\NetBeansProjects\\CRUD_Escuela\\Ruta\\" + unaParte.getFileName());
                        InputStream imagenIS = unaParte.getInputStream();
                        byte[] bytes = new byte[1000000];
                        int leidos = 0;
                        while ((leidos = imagenIS.read(bytes)) > 0) {
                            guardarFichero.write(bytes, 0, leidos);
                        }

                        //Tomar la ruta de la imagen y guardarla en la BD
                        String fichero = "C:\\Users\\admon\\Documents\\NetBeansProjects\\CRUD_Escuela\\Ruta\\" + unaParte.getFileName();
                        System.out.println("Longitud " + fichero.length());
                        FileInputStream imagen = new FileInputStream(fichero);

                        InsertarImagen(fichero);

                        /*if (Problema.BuscaRepetidoIMG(idMensaje) == 0) {
                            System.out.println("---------------------------------");
                            System.out.println("Imagen " + unaParte.getContentType() + " No existe: Agregando...");
                            System.out.println("---------------------------------");
                            InsertarImagen(fichero, idMensaje);
                        } else {
                            System.out.println("Imagen " + unaParte.getFileName() + " Existe\n");
                        }*/
                    } else {
                        // Si no es ninguna de las anteriores, se escribe en pantalla
                        // el tipo.
                        System.out.println("Recibido " + unaParte.getContentType());
                        System.out.println("---------------------------------");
                    }
                }
            }
        } catch (IOException | MessagingException ex) {
            System.out.println("Error " + ex);
        }
    }
}
