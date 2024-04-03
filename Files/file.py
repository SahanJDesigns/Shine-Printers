for i in range(1, 100001):
    file_name = f"file{i}.txt"
    with open(file_name, "w") as file:
        file.write(file_name)
    print(f"File created: {file_name}")
