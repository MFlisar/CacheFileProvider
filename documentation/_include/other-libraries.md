You can find an overview of my main libraries that do all play well together with short descriptions on my homepage here:

[Overview](https://mflisar.github.io/github/){:target="_blank"}

But here's also a small table just showing which libraries I do offer that may be interesting for you as well.

{% macro table_row(project) %}
<tr>
<td><a href="{{ project["link"] }}" target="_blank">{{ project["name"] }}</a></td>
<td><img class="exclude-glightbox" src="https://img.shields.io/maven-central/v/{{ project["maven"] }}?label=&style=for-the-badge&labelColor=444444&color=grey" /></td>
</tr>
{% endmacro %}

<table>
    <tr>
        <th>Library</th>
        <th>Version</th>
    </tr>
    {% for key, value in other_projects["libraries"].items() %}
        <tr style="background-color:var(--md-primary-fg-color--light);">
            <th colspan="2">{{key}}</th>
        </tr>
        {% for prj in value %}
            {% if prj["name"] != project["library"]["name"] %}
                {{ table_row(prj) }}
            {% endif %}
        {% endfor %}
    {% endfor %}
</table>