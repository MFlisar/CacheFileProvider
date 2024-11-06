# Other Libraries

Here you can find an overview of my main libraries that do all play well together including some short descriptions.

{% macro table_row(project) %}
<tr>
<td>
{% if project["image"] is defined %}
<img class="exclude-glightbox" src="{{ project["image"] }}" style="max-height:400px;">
{% endif %}
</td>
<td style="text-align: center; vertical-align: middle;">
    <a href="{{ project["link"] }}" target="_blank">{{ project["name"] }}</a>
<td>{{ project["description"] }}<br><img class="exclude-glightbox" src="https://img.shields.io/maven-central/v/{{ project["maven"] }}?label=&style=for-the-badge&labelColor=444444&color=grey" /></td>
</tr>
{% endmacro %}

<table>
    <tr>
        <th>Image</th>
        <th>Library</th>
        <th>Description</th>
    </tr>
    {% for key, value in other_projects["libraries"].items() %}
        <tr style="background-color:var(--md-primary-fg-color--light);">
            <th colspan="3">{{key}}</th>
        </tr>
        {% for prj in value %}
            {% if prj["name"] != project["library"]["name"] and prj["name"] != "Toolbox" %}
                {{ table_row(prj) }}
            {% endif %}
        {% endfor %}
    {% endfor %}
</table>