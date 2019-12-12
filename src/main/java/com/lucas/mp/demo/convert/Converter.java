package com.lucas.mp.demo.convert;

/**
 * @param <T> Entity
 * @param <S> DTO
 * @author liuxu
 */
public interface Converter<T, S> {

    /**
     * 将DTO对象转换成Entity对象
     *
     * @param s DTO
     * @return Entity
     */
    T doForward(S s);

    /**
     * 将Entity对象转换成DTO对象
     *
     * @param t Entity
     * @return DTO
     */
    S doBackward(T t);


}
