package com.sortingvisualizer;
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SortingVisualizer extends JPanel {
    private int[] array;
    private final int ARRAY_SIZE = 50;
    private final int BAR_WIDTH = 10;

    public SortingVisualizer() {
        array = new int[ARRAY_SIZE];
        generateRandomArray();
        setPreferredSize(new Dimension(ARRAY_SIZE * BAR_WIDTH, 400));
    }

    // Generate a random array
    private void generateRandomArray() {
        Random rand = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = rand.nextInt(300) + 1; // Random values between 1 and 300
        }
        repaint();
    }

    // Render the array as bars
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect(i * BAR_WIDTH, 400 - array[i], BAR_WIDTH - 1, array[i]);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Algorithm Visualizer");
        SortingVisualizer visualizer = new SortingVisualizer();

        JButton generateButton = new JButton("Generate Array");
        JButton bubbleSortButton = new JButton("Bubble Sort");
        JButton selectionSortButton = new JButton("Selection Sort");
        JButton insertionSortButton = new JButton("Insertion Sort");

        generateButton.addActionListener(e -> {
            visualizer.generateRandomArray();
        });

        bubbleSortButton.addActionListener(e -> {
            new Thread(() -> {
                try {
                    new BubbleSort(visualizer.array).sort();
                    visualizer.repaint();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

        selectionSortButton.addActionListener(e -> {
            new Thread(() -> {
                try {
                    new SelectionSort(visualizer.array).sort();
                    visualizer.repaint();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

        insertionSortButton.addActionListener(e -> {
            new Thread(() -> {
                try {
                    new InsertionSort(visualizer.array).sort();
                    visualizer.repaint();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);
        buttonPanel.add(bubbleSortButton);
        buttonPanel.add(selectionSortButton);
        buttonPanel.add(insertionSortButton);

        frame.add(visualizer, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SortingVisualizer extends JPanel {
    private int[] array;
    private final int ARRAY_SIZE = 50;
    private final int BAR_WIDTH = 10;

    public SortingVisualizer() {
        array = new int[ARRAY_SIZE];
        generateRandomArray();
        setPreferredSize(new Dimension(ARRAY_SIZE * BAR_WIDTH, 400));
    }

    // Generate a random array
    private void generateRandomArray() {
        Random rand = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = rand.nextInt(300) + 1; // Random values between 1 and 300
        }
        repaint();
    }

    // Render the array as bars
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect(i * BAR_WIDTH, 400 - array[i], BAR_WIDTH - 1, array[i]);
        }
    }

    // Bubble Sort Algorithm
    public void bubbleSort() throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    repaint();
                    Thread.sleep(50); // Delay for visualization
                }
            }
        }
    }

    // Selection Sort Algorithm
    public void selectionSort() throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            repaint();
            Thread.sleep(50); // Delay for visualization
        }
    }

    // Insertion Sort Algorithm
    public void insertionSort() throws InterruptedException {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            repaint();
            Thread.sleep(50); // Delay for visualization
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Algorithm Visualizer");
        SortingVisualizer visualizer = new SortingVisualizer();

        JButton generateButton = new JButton("Generate Array");
        JButton bubbleSortButton = new JButton("Bubble Sort");
        JButton selectionSortButton = new JButton("Selection Sort");
        JButton insertionSortButton = new JButton("Insertion Sort");

        generateButton.addActionListener(e -> {
            visualizer.generateRandomArray();
        });

        bubbleSortButton.addActionListener(e -> {
            new Thread(() -> {
                try {
                    visualizer.bubbleSort();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

        selectionSortButton.addActionListener(e -> {
            new Thread(() -> {
                try {
                    visualizer.selectionSort();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

        insertionSortButton.addActionListener(e -> {
            new Thread(() -> {
                try {
                    visualizer.insertionSort();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);
        buttonPanel.add(bubbleSortButton);
        buttonPanel.add(selectionSortButton);
        buttonPanel.add(insertionSortButton);

        frame.add(visualizer, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}