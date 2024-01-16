package com.example.project.Stacks;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import java.util.function.UnaryOperator;

public class Stacks {
    private static Stack<String> usernameStack = new Stack<>();
    private static Stack<String> emailStack = new Stack<>();
    private static Stack<String> phoneStack = new Stack<>();
    private static Stack<String> nameStack = new Stack<>();
    private static Stack<Integer> ageStack = new Stack<>();
    private static Stack<String> countryStack = new Stack<>();
    private static Stack<Integer> weightStack = new Stack<>();
    private static Stack<Integer> heightStack = new Stack<>();
    private static Stack<String> genderStack = new Stack<>();
    private static Stack<Integer> height_calculatorStack = new Stack<>();
    private static Stack<String> username_calculatorStack = new Stack<>();
    private static Stack<Integer> age_calculatorStack = new Stack<>();
    private static Stack<Integer> weight_calculatorStack = new Stack<>();
    private static Stack<Integer> ratingStack = new Stack<>();
    private static Stack<String> username_rateUsStack = new Stack<>();

    public static void pushToRatingStack(Integer value) {
         ratingStack.push(value);
    }
    public static Integer popFromRatingStack() {
        return ratingStack.pop();
    }
    public static boolean IsRatingStackEmpty() {
        return ratingStack.isEmpty();
    }


    public static String peekUsernameStack() {
        return usernameStack.peek();
    }
    public static String peekUsernameRateUsStack() {
        return username_rateUsStack.peek();
    }
    public static void pushToUsernameRateUsStack(String value) {
         username_rateUsStack.push(value);
    }
    public static String popFromUsernameRateUsStack()
    {
        return username_rateUsStack.pop();
    }
    public static boolean IsUsernameRateUsStackEmpty() {
        return username_rateUsStack.isEmpty();
    }

    public static void pushToHeightCalculatorStack(Integer value) {
         height_calculatorStack.push(value);
    }
    public static Integer popFromHeightCalculatorStack() {
        return height_calculatorStack.pop();
    }
    public static boolean IsHeightCalculatorStackEmpty() {
        return height_calculatorStack.isEmpty();
    }

    public static void pushToAgeCalculatorStack(Integer value) {
       age_calculatorStack.push(value);
    }
    public static Integer popFromAgeCalculatorStack() {
        return age_calculatorStack.pop();
    }
    public static boolean IsAgeCalculatorStackEmpty() {
        return age_calculatorStack.isEmpty();
    }

    public static void pushToUsernameCalculatorStack(String value) {
        username_calculatorStack.push(value);
    }
    public static String popFromUsernameCalculatorStack() {
        return username_calculatorStack.pop();
    }
    public static boolean IsUsernameCalculatorStackEmpty() {
        return username_calculatorStack.isEmpty();
    }


    public static void pushToWeightCalculatorStack(Integer value) {
        weight_calculatorStack.push(value);
    }
    public static Integer popFromWeightCalculatorStack() {
        return weight_calculatorStack.pop();
    }
    public static boolean IsWeightCalculatorStackEmpty() {
        return weight_calculatorStack.isEmpty();
    }

    public static void pushToAgeStack(Integer value) {
        ageStack.push(value);
    }
    public static Integer popFromAgeStack() {
        return ageStack.pop();
    }
    public static boolean IsAgeStackEmpty() {
        return ageStack.isEmpty();
    }
    public static void pushToCountryStack(String value) {
        countryStack.push(value);
    }
    public static String popFromCountryStack() {
        return countryStack.pop();
    }
    public static boolean IsCountryStackEmpty() {
        return countryStack.isEmpty();
    }
    public static void pushToPhoneStack(String value) {
        phoneStack.push(value);
    }
    public static String popFromPhoneStack() {
        return phoneStack.pop();
    }
    public static boolean IsPhoneStackEmpty() {
        return phoneStack.isEmpty();
    }
    public static void pushToNameStack(String item) {
        nameStack.push(item);
    }
    public static String popFromNameStack() {
        return nameStack.pop();
    }
    public static boolean IsNameStackEmpty() {
        return nameStack.isEmpty();
    }
    public static void pushToEmailStack(String value) {
        emailStack.push(value);
    }
    public static String popFromEmailStack() {
        return emailStack.pop();
    }
    public static boolean IsEmailStackEmpty() {
        return emailStack.isEmpty();
    }
    public static void pushToUsernameStack(String value) {
        usernameStack.push(value);
    }
    public static String popFromUsernameStack() {
        return  usernameStack.pop();
    }
    public static boolean IsUsernameStackEmpty() {
        return usernameStack.isEmpty();
    }
    public static void pushToWeightStack(Integer value) {
        weightStack.push(value);
    }
    public static Integer popFromWeightStack() {
        return weightStack.pop();
    }
    public static boolean IsWeightStackEmpty() {
        return weightStack.isEmpty();
    }
    public static void pushToHeightStack(Integer value) {
        heightStack.push(value);
    }
    public static Integer popFromHeightStack() {
        return heightStack.pop();
    }
    public static boolean IsHeightStackEmpty() {
        return heightStack.isEmpty();
    }
    public static void pushToGenderStack(String value) {
        genderStack.push(value);
    }
    public static String popFromGenderStack() {
        return genderStack.pop();
    }
    public static boolean IsGenderStackEmpty() {
        return genderStack.isEmpty();
    }


}
