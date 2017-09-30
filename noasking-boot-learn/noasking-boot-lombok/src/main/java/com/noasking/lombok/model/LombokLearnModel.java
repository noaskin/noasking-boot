package com.noasking.lombok.model;

import lombok.*;

import java.io.*;

/**
 * Created by MaJing on 2017/9/30.
 */
@NoArgsConstructor //自动生成无参数构造函数。
@AllArgsConstructor //自动生成全参数构造函数。
@Data //自动为所有字段添加@ToString, @EqualsAndHashCode, @Getter方法，为非final字段添加@Setter,和@RequiredArgsConstructor!
public class LombokLearnModel {

    /**
     * val
     * Finally! Hassle-free final local variables.
     *
     * @NonNull or: How I learned to stop worrying and love the NullPointerException.
     * @Cleanup Automatic resource management: Call your close() methods safely with no hassle.
     * @Getter/@Setter Never write public int getFoo() {return foo;} again.
     * @ToString No need to start a debugger to see your fields: Just let lombok generate a toString for you!
     * @EqualsAndHashCode Equality made easy: Generates hashCode and equals implementations from the fields of your object..
     * @NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor
     * Constructors made to order: Generates constructors that take no arguments, one argument per final / non-nullfield, or one argument for every field.
     * @Data All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
     * @Value Immutable classes made very easy.
     * @Builder ... and Bob's your uncle: No-hassle fancy-pants APIs for object creation!
     * @SneakyThrows To boldly throw checked exceptions where no one has thrown them before!
     * @Synchronized synchronized done right: Don't expose your locks.
     * @Getter(lazy=true) Laziness is a virtue!
     * @Log Captain's Log, stardate 24435.7: "What was that line again?"
     * experimental
     * Head to the lab: The new stuff we're working on.
     */

    /**
     * @Getter / @Setter
     * <p>
     *   可以作用在类上和属性上，放在类上，会对所有的非静态(non-static)属性生成Getter/Setter方法，放在属性上，会对该属性生成Getter/Setter方法。并可以指定Getter/Setter方法的访问级别。
     * @EqualsAndHashCode   默认情况下，会使用所有非瞬态(non-transient)和非静态(non-static)字段来生成equals和hascode方法，也可以指定具体使用哪些属性。
     * @ToString   生成toString方法，默认情况下，会输出类名、所有属性，属性会按照顺序输出，以逗号分割。
     * @NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor
     * <p>
     *   无参构造器、部分参数构造器、全参构造器，当我们需要重载多个构造器的时候，Lombok就无能为力了。
     * @Data   @ToString, @EqualsAndHashCode, 所有属性的@Getter, 所有non-final属性的@Setter和@RequiredArgsConstructor的组合，通常情况下，我们使用这个注解就足够了。
     */

    private String name;

    public void NonNullExample(@NonNull String name) {//可以帮助我们避免空指针。
        this.name = name;
    }


    public static void main(String[] args) throws IOException {
        @Cleanup InputStream in = new FileInputStream(args[0]); //自动帮我们调用close()方法。
        @Cleanup OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }

}
