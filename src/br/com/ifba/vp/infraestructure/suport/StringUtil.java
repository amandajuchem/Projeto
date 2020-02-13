package br.com.ifba.vp.infraestructure.suport;

/**
 *
 * @author jonatasbastos
 */

public class StringUtil {
    private volatile static StringUtil instance;
    //Padrão Singleton
    public static StringUtil getInstance () {
        if (instance == null) {
            synchronized(StringUtil.class) {
                if (instance == null) {
                    instance = new StringUtil();
                }
            }
        }
        
        return instance;
    }
    //Verifica se a string é nula
    public boolean isNull (final String str) {
        return (str == null);
    }
    //verifica se a string é vazia
    public boolean isEmpty (final String str) {
        return (isNull(str) ? true : (str.trim().equals("")));
    }
    //Verifica se a string é nula e vazia
    public boolean isNullAndEmpty(final String str) {
        return (isNull(str) && isEmpty(str));
    }
    //verifica se a string é nula ou vazia
    public boolean isNullOrEmpty(final String str) {
        return (isNull(str) || isEmpty(str));
    }
}