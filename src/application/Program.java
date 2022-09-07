package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<>();

		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		
		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Dados da " + i + "a aula: ");
			System.out.print("Conteúdo ou tarefa (c/t)?");
			char type = sc.next().charAt(0);
			
			while (type != 'c' && type != 't'  ) {
				System.out.print("incorrect letter!");
				System.out.print("Conteúdo ou tarefa (c/t)?");
				type = sc.next().charAt(0);
			}
			
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if (type == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos:");
				int seconds = sc.nextInt();

				list.add(new Video(title, url, seconds));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();

				list.add(new Task(title, description, questionCount));
			}

		}
		int sum = 0;
		for (Lesson lesson : list) {

			sum += lesson.duration();
		}
		System.out.print("DURAÇÃO TOTAL DO CURSO = " + sum +" segundos");
	}

}
